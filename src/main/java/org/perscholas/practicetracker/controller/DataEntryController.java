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
    public ModelAndView dataEntry(@ModelAttribute("form") @Valid DataEntryFormBean form,
                                  @ModelAttribute("session") @Valid DataEntryFormBean session) throws Exception {

//        BindingResult resultForm, BindingResult resultSession

        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntry");



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

//        Session session = sessionDao.findByUsername(currentUserName);

        List<Session> allSession = sessionDao.getAllSessions();
        response.addObject("session", allSession);
        User user = userDao.findByUsername(currentUserName);
        List<UserSession> userSessions = userSessionDao.findByUserId(user.getId());
        response.addObject("userSession", userSessions);
        form = new DataEntryFormBean();
        response.addObject("form", form);
        System.out.println(allSession);


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUserName = authentication.getName();
//        UserSession userSession = new UserSession();
//        User user = userDao.findByUsername(currentUserName);
////        response.addObject("user", user);
////        if (userSession.getId() == null) {
////            userSession = new UserSession();
////        } else {
////            userSession = userSessionDao.findById(entry.getId());
////        }
////        userSession =
//
//
//        userSession.setUserId(user.getId());
//        userSession.setSessionName(form.getSessionName());
////        userSession.setNotes(form.getNotes());
//        System.out.println(userSession);
//        userSessionDao.save(userSession);

        return response;

    }

    @RequestMapping(value = "/user/dataEntrySubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView dataEntrySubmit(@ModelAttribute("form") @Valid DataEntryFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("dataEntry/dataEntry");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        UserSession userSession = new UserSession();
        User user = userDao.findByUsername(currentUserName);
//        response.addObject("user", user);
//        if (userSession.getId() == null) {
//            userSession = new UserSession();
//        } else {
//            userSession = userSessionDao.findById(entry.getId());
//        }
//        userSession =


        userSession.setUserId(user.getId());
        userSession.setSessionName(form.getSessionName());
        userSession.setDate(form.getDate());
        userSession.setSessionId(form.getSessionId());

        userSession.setTime(form.getTime());
        userSession.setRating(form.getRating());
        userSession.setNotes(form.getNotes());
        System.out.println(userSession);
        userSessionDao.save(userSession);

        return response;
    }

    }
