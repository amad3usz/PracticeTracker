package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserRoleDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserRole;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public ModelAndView register(@RequestParam(required = false) Integer id, @ModelAttribute("form") @Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");
        for ( FieldError error : errors.getFieldErrors() ) {
            form.getErrorMessages().add(error.getDefaultMessage());
            System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
        }
        form = new RegisterFormBean();
        response.addObject("form", form);
        return response;
    }

    @RequestMapping(value = "/registerEdit", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/registerEdit");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User user = userDao.findByUsername(currentUserName);
        response.addObject("user", user);

        if ( user.getId() != null) {
            RegisterFormBean form = new RegisterFormBean();
            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setPassword(user.getPassword());
            form.setConfirmPassword(user.getConfirmPassword());
            form.setDOB(user.getDOB());
            form.setGender(user.getGender());
            form.setSkillsPracticing(user.getSkillsPracticing());
            form.setProfileIcon(user.getProfileIcon());
            form.setId(user.getId());

            response.addObject("form", form);

        } else {
            //id has not been passed so it is a create
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("form", form);
        }
        return response;
    }

    @RequestMapping(value = { "/registerSubmit" }, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@ModelAttribute("form") @Valid RegisterFormBean form, BindingResult errors,
                                       HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String firstName = form.getFirstName();
        String lastName = form.getLastName();
        String email = form.getEmail();
        String username = form.getUsername();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String gender = form.getGender();
        String DOB = form.getDOB();
//        String []skillsPracticing = request.getParameterValues("skillsPracticing");
//        String skillsPracticing2 = Arrays.toString(skillsPracticing);
        String profileIcon = form.getProfileIcon();

        System.out.println(form); //from toString method in bean, formats the output to individual lines without having to assign each value to a variable
        System.out.println(firstName + lastName + email + username + password + confirmPassword +  gender + DOB + profileIcon);

        if (errors.hasErrors()) {
            for ( FieldError error : errors.getFieldErrors() ) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.setViewName("register/register");
        } else {

            User user = null;

            if (form.getId() == null) {
                user = new User();
            } else {
                user = userDao.findById(form.getId());
            }


            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUsername(form.getUsername());
            user.setDOB(form.getDOB());
            user.setGender(form.getGender());
            user.setSkillsPracticing(String.valueOf(form.getSkillsPracticing()));
            user.setProfileIcon(form.getProfileIcon());


            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);
            user.setConfirmPassword(encryptedPassword);
//            UserRole userRole = userDao.findByUsername();
//            userRole.setUserId(user);
//            userRole.setUserRole("USER");
            //saves new user, and will return a user object with id populated
            //creates a new autoincremented id and returns object with new value
            user = userDao.save(user);
            if (form.getId() == null) {
                UserRole userRole = new UserRole();

                userRole.setUser(user);
                userRole.setUserRole("USER");

                userRoleDao.save(userRole);
            }



            response.setViewName("register/registrationSuccess");
        }
        return response;
    }

    @RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/registrationSuccess");
//        String username = (String) session.getAttribute(SESSION_KEY);
//        if (StringUtils.equals(username, "tom")) {
//            // add the username to the response model so that it can be displayed on the jsp page.
//            response.addObject("loginusername", username);
//
//
//        } else {
//            // need to implement here to redirect back to login page
//            // because it means the user has requested the /success url
//            // but is not in the session
//            response.setViewName("redirect:/register");
//        }

        return response;
    }


}
