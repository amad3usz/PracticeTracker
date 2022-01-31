package org.perscholas.practicetracker.controller;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.practicetracker.loginForm.LoginFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //create login controller
    //create a loginSubmit.jsp
    //create a login.jsp with form for username and password
    //make the form submit to loginSubmit
    //in loginSubmit, check if username is tom and password is jerry
    //if true, then add tom to the session and return the success view
    //otherwise return the login view
    //in the login method, check if the username tom is in the session and if so return the success view

    private static String SESSION_KEY = "usernameSessionKey";
    private static String SESSION_ERROR_MESSAGE = "errorMessageKey";

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        String username = (String) session.getAttribute(SESSION_KEY);

        if(StringUtils.equals(username, "tom")) {
            response.setViewName("redirect:/success");
//            response.addObject("loginusername", username);
        } else {
            String errorMessage = (String)session.getAttribute(SESSION_ERROR_MESSAGE);
            response.addObject("errorMessage", errorMessage);
            response.setViewName("login/login");
        }

//        response.setViewName("login/login"); //login folder to login.jsp

        return response;
    }

    @RequestMapping(value = { "/loginSubmit" }, method = RequestMethod.GET)
    public ModelAndView loginSubmit(LoginFormBean form,
                                    HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
//        response.setViewName("login/login");
        String username = form.getUsernameLogin();
        String password = form.getPasswordLogin();

        if (StringUtils.equals(username,"tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute(SESSION_KEY, username);
            response.setViewName("redirect:/success");
            session.setAttribute(SESSION_ERROR_MESSAGE, null);
//            session.setAttribute("username", username);
////            response.addObject("loginusername", username); //cant set on the model for redirect
//            response.setViewName("redirect:/success");

        } else {
//            response.setViewName("login/login");
            session.setAttribute(SESSION_KEY, null);
            response.setViewName("redirect:/login");

            session.setAttribute(SESSION_ERROR_MESSAGE, "Invalid Login");
        }

        return response;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(LoginFormBean form, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

//        String username = form.getUsernameLogin();
//        String password = form.getPasswordLogin();

        String username = (String) session.getAttribute(SESSION_KEY);
        if (StringUtils.equals(username, "tom")) {
            // add the username to the response model so that it can be displayed on the jsp page.
            response.addObject("loggedInUser", username);

            response.setViewName("login/success");
        } else {
            // need to implement here to redirect back to login page
            // because it means the user has requested the /success url
            // but is not in the session
            response.setViewName("redirect:/login");
        }

        return response;
    }



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpSession session) throws Exception {
        session.invalidate(); //tell tomcat user has logged out
        ModelAndView response = new ModelAndView();
        //this is how to do a redirect in spring mvc and
        response.setViewName(("redirect:/login"));
        return response;
    }
}
