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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    public ModelAndView dataEntry(@ModelAttribute("form") @Valid DataEntryFormBean form,
                                  @ModelAttribute("session") @Valid DataEntryFormBean session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntry");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        List<Session> allSession = sessionDao.getAllSessions();
        response.addObject("session", allSession);

        User user = userDao.findByUsername(currentUserName);
        List<UserSession> userSessions = userSessionDao.findByUserId(user.getId());
        response.addObject("userSession", userSessions);

        form = new DataEntryFormBean();
        response.addObject("form", form);

        System.out.println(allSession);

        return response;

    }



    @RequestMapping(value = "/user/dataEntryEdit", method = {RequestMethod.GET})
    public ModelAndView dataEntryEdit(@ModelAttribute("form") @Valid DataEntryFormBean form, @RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntryEdit");
        form = new DataEntryFormBean();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        List<Session> allSession = sessionDao.getAllSessions();
        response.addObject("session", allSession);

        User user = userDao.findByUsername(currentUserName);
//        List<UserSession> userSessions = userSessionDao.findByUserId(user.getId());
//        response.addObject("userSession", userSession);

        UserSession userSession = userSessionDao.findById(id);
        response.addObject("userSession", userSession);
        form.setId(userSession.getId());
        form.setUserId(userSession.getUserId());
        form.setSessionName(userSession.getSessionName());
        form.setDate(userSession.getDate());
        form.setSessionId(userSession.getSessionId());
        form.setTime(userSession.getTime());
        form.setRating(userSession.getRating());
        form.setNotes(userSession.getNotes());
        System.out.println(userSession);
        userSessionDao.save(userSession);
        response.addObject("form", form);
        return response;
    }

    @RequestMapping(value = "/user/dataEntrySubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView dataEntrySubmit(@ModelAttribute("form") @Valid DataEntryFormBean form, @RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntry");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        UserSession userSession = new UserSession();
        User user = userDao.findByUsername(currentUserName);

        userSession.setId(form.getId());
        userSession.setUserId(user.getId());
        userSession.setSessionName(form.getSessionName());
        userSession.setDate(form.getDate());
        userSession.setSessionId(form.getSessionId());
        userSession.setTime(form.getTime());
        userSession.setRating(form.getRating());
        userSession.setNotes(form.getNotes());
        System.out.println(userSession);
        userSessionDao.save(userSession);
        response.setViewName("dataEntry/dataEntrySuccess");
        return response;
    }

    @RequestMapping(value = "user/dataEntrySuccess", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntrySuccess");
        return response;
    }

    }
