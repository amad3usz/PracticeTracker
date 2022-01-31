package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.registerForm.RegisterFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;


@Controller
@RequestMapping("/registration")
public class RegisterController {

//    private static String SESSION_KEY = "usernameSessionKey";
//    private static String SESSION_ERROR_MESSAGE = "errorMessageKey";

    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");
//        String username = (String) session.getAttribute(SESSION_KEY);
//
//        if(StringUtils.equals(username, "tom")) {
//            response.setViewName("redirect:/registrationSuccess");
////            response.addObject("loginusername", username);
//        } else {
//            String errorMessage = (String)session.getAttribute(SESSION_ERROR_MESSAGE);
//            response.addObject("errorMessage", errorMessage);
//            response.setViewName("register/register");
//        }

//        response.setViewName("login/login"); //login folder to login.jsp

        return response;
    }

    @RequestMapping(value = { "/registerSubmit" }, method = RequestMethod.GET)
    public ModelAndView registerSubmit(RegisterFormBean form,
                                    HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();


        String firstName = form.getFirstName();
        String lastName = form.getLastName();
        String email = form.getEmail();
        String username = form.getUsername();
        String password = form.getPassword();
        String gender = form.getGender();
        String DOB = form.getDOB();
        String []skillsPracticing = request.getParameterValues("skillsPracticing");
        String skillsPracticing2 = Arrays.toString(skillsPracticing);
        String profileImage = form.getProfileImage();

        System.out.println(form); //from toString method in bean, formats the output to individual lines without having to assign each value to a variable
        System.out.println(firstName + lastName + email + username + password + gender + DOB + skillsPracticing2 + profileImage);
//        if (StringUtils.equals(username,"tom") && StringUtils.equals(password, "jerry")) {
//            session.setAttribute(SESSION_KEY, form.getUsername());
//            response.setViewName("redirect:/registrationSuccess");
//            session.setAttribute(SESSION_ERROR_MESSAGE, null);
//            session.setAttribute("username", username);
//            response.addObject("loginusername", username); //cant set on the model for redirect
//
//        } else {
//            session.setAttribute(SESSION_KEY, null);
//            response.setViewName("redirect:/login");
//
//            session.setAttribute(SESSION_ERROR_MESSAGE, "Invalid Login");
//        }

        return response;
    }

    @RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

//        String username = (String) session.getAttribute(SESSION_KEY);
//        if (StringUtils.equals(username, "tom")) {
//            // add the username to the response model so that it can be displayed on the jsp page.
//            response.addObject("loginusername", username);
//
//            response.setViewName("register/registrationSuccess");
//        } else {
//            // need to implement here to redirect back to login page
//            // because it means the user has requested the /success url
//            // but is not in the session
//            response.setViewName("redirect:/register");
//        }

        return response;
    }


}
