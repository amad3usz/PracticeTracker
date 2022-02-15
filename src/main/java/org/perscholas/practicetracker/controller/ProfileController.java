package org.perscholas.practicetracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.practicetracker.database.dao.FollowingDAO;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserSessionDAO;
import org.perscholas.practicetracker.database.entity.Following;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class ProfileController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserSessionDAO userSessionDao;

    @Autowired
    FollowingDAO followingDao;

    @RequestMapping(value = "/user/myProfile", method = RequestMethod.GET)
    public ModelAndView myProfile() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userProfile/userProfile");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User user = userDao.findByUsername(currentUserName);
        response.addObject("user", user);


        List<UserSession> us = userSessionDao.findByUserIdOrderByDateDesc(user.getId());
        response.addObject("userSession", us);
        return response;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profile(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userProfile/userProfile");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user2 = userDao.findByUsername(currentUserName);
        Integer userId = user2.getId();

        Following exists = followingDao.findByUserIdAndFollowingId(userId, id);
        if (exists != null) {
            boolean following = true;
            response.addObject("exists", following);
        }
        if (exists == null) {
            boolean following = false;
            response.addObject("exists", following);
        }


        User user = userDao.findById(id);
        response.addObject("user", user);

        List<UserSession> us = userSessionDao.findByUserId(user.getId());
        response.addObject("userSession", us);


        return response;
    }
}