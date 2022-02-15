package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.dataEntryForm.DataEntryFormBean;
import org.perscholas.practicetracker.database.dao.SessionDAO;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserSessionDAO;
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
public class InputHistoryController {
    @Autowired
    private SessionDAO sessionDao;

    @Autowired
    private UserSessionDAO userSessionDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/inputHistory", method = RequestMethod.GET)
    public ModelAndView dataEntry(@ModelAttribute("form") @Valid DataEntryFormBean form,
                                  @ModelAttribute("session") @Valid DataEntryFormBean session) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("inputHistory/inputHistory");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User user = userDao.findByUsername(currentUserName);
        List<UserSession> userSessions = userSessionDao.FindAllWithDescriptionQueryOrderByUserIdOrderByDateDesc(user.getId());
        response.addObject("userSession", userSessions);

        // NEED TO FIGURE OUT HOW TO PULL SESSION NAME FROM SESSIONS TABLE USING USERSESSION SESSION_ID
//        Session sessionType = sessionDao.findBySessionId(userSessions);
//        response.addObject("sessionType", sessionType);

        return response;

    }

    @RequestMapping(value = "/user/deleteEntry", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("redirect:/user/inputHistory");
//        System.out.println(delete());
        UserSession deleteSession = userSessionDao.findById(id);
        if (deleteSession != null) {
            userSessionDao.delete(deleteSession);
        }


        return response;
    }
}
