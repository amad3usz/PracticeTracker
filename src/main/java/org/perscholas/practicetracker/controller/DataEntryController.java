package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.dataEntryForm.DataEntryFormBean;
import org.perscholas.practicetracker.database.dao.SessionDAO;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserSessionDAO;
import org.perscholas.practicetracker.database.entity.Session;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DataEntryController {

    @Autowired
    private SessionDAO sessionDao;

    @Autowired
    private UserSessionDAO userSessionDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/dataEntry", method = RequestMethod.GET)
    public ModelAndView dataEntry(@ModelAttribute("form") @Valid DataEntryFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntry");

        // get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // retrieve all session types to populate the new entry page
        List<Session> allSession = sessionDao.getAllSessions();
        response.addObject("session", allSession);

        // retrieve all user sessions for the authenticated user
        User user = userDao.findByUsername(currentUserName);
        List<UserSession> userSessions = userSessionDao.findByUserId(user.getId());
        response.addObject("userSession", userSessions);

        // create new data entry form bean
        form = new DataEntryFormBean();
        response.addObject("form", form);

        return response;

    }

    @RequestMapping(value = "/user/dataEntryEdit", method = {RequestMethod.GET})
    public ModelAndView dataEntryEdit(@ModelAttribute("form") @Valid DataEntryFormBean form, @RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntryEdit");

        // pull list of session types from database to populate form dropdown menu
        List<Session> allSession = sessionDao.getAllSessions();
        response.addObject("session", allSession);

        // pull user session id from URL to prepopulate form with data that is to be edited
        UserSession userSession = userSessionDao.findById(id);
        response.addObject("userSession", userSession);

        // create new data entry form bean
        form = new DataEntryFormBean();
        response.addObject("form", form);

        // populate form with user session details
        form.setId(userSession.getId());
        form.setUserId(userSession.getUser().getId());
        form.setSessionName(userSession.getSessionName());
        form.setDate(userSession.getDate());
        form.setSessionId(userSession.getSessionId());
        form.setTime(userSession.getTime());
        form.setRating(userSession.getRating());
        form.setNotes(userSession.getNotes());

        return response;
    }

    @RequestMapping(value = "/user/dataEntrySubmit", method = {RequestMethod.POST})
    public ModelAndView dataEntrySubmit(@ModelAttribute("form") @Valid DataEntryFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntrySuccess");

        // get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // get authenticated user information
        User user = userDao.findByUsername(currentUserName);

        // create new user session
        UserSession userSession = new UserSession();

        // set form inputs to be saved to user session
        userSession.setId(form.getId());
        userSession.setUser(user);
        userSession.setSessionName(form.getSessionName());
        userSession.setDate(form.getDate());
        userSession.setSessionId(form.getSessionId());
        userSession.setTime(form.getTime());
        userSession.setRating(form.getRating());
        userSession.setNotes(form.getNotes());

        // save inputs to database
        userSessionDao.save(userSession);

        return response;
    }

    @RequestMapping(value = "user/dataEntrySuccess", method = RequestMethod.GET)
    public ModelAndView success() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntrySuccess");

        return response;
    }

}
