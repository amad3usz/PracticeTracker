package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserRoleDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserRole;
import org.perscholas.practicetracker.registerForm.RegisterFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute("form") @Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");

        // create new form object
        form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = { "/registerSubmit" }, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@ModelAttribute("form") @Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        // show errors with after attempting to submit
        // errors code by Eric Heilig
        if (errors.hasErrors()) {
            for ( FieldError error : errors.getFieldErrors() ) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.setViewName("register/register");
        } else {

            // create new user object for new user
            User user = new User();

            // set values to user object from form
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUsername(form.getUsername());
            user.setDOB(form.getDOB());
            user.setGender(form.getGender());
            user.setSkillsPracticing(String.valueOf(form.getSkillsPracticing()));
            user.setProfileIcon(form.getProfileIcon());

            // encrypt password
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            // set encrypted passwords to user object
            user.setPassword(encryptedPassword);
            user.setConfirmPassword(encryptedPassword);

            // saves new user, and will return a user object with id populated
            // creates a new autoincrement id and returns object with new value
            user = userDao.save(user);

            if (form.getId() == null) {
                // creates new user in user role table
                UserRole userRole = new UserRole();

                // gets new user to user role
                userRole.setUser(user);
                // assigns role of "user" to new user
                userRole.setUserRole("USER");

                // saves new user with user role in user role table
                userRoleDao.save(userRole);
            }

            response.setViewName("register/registrationSuccess");
        }

        return response;
    }

    @RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
    public ModelAndView registrationSuccess() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/registrationSuccess");

        return response;
    }


}
