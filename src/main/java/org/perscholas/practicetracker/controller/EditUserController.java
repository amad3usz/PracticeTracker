package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.registerForm.EditFormBean;
import org.perscholas.practicetracker.registerForm.RegisterFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/user")
public class EditUserController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registerEdit", method = RequestMethod.GET)
    public ModelAndView registerEdit() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/registerEdit");

        // get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // get authenticated user information
        User user = userDao.findByUsername(currentUserName);
        response.addObject("user", user);

        // create new a new register form bean
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        // prepopulate form with user values
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setUsername(user.getUsername());
        form.setId(user.getId());
        form.setDOB(user.getDOB());
        form.setGender(user.getGender());
        form.setSkillsPracticing(user.getSkillsPracticing());
        form.setProfileIcon(user.getProfileIcon());

        return response;
    }

    @RequestMapping(value = {"/registerSubmit"}, method = {RequestMethod.POST})
    public ModelAndView registerSubmit(@ModelAttribute("form") @Valid EditFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        // show errors with inputs
        // errors code by Eric Heilig
        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.setViewName("register/registerEdit");
        } else {

            // create user object to save form data into from previously registered user
            User user = userDao.findById(form.getId());

            // get form values and set them to user object
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

            // save user edits to database
            userDao.save(user);

            response.setViewName("register/registrationSuccess");
        }

        return response;
    }
}
