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

        // get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // create user object from current user
        User user = userDao.findByUsername(currentUserName);
        response.addObject("user", user);

        // retrieve user session information to display on profile page and create user session object
        List<UserSession> us = userSessionDao.findByUserIdOrderByDateDesc(user.getId());
        response.addObject("userSession", us);

        return response;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profile(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userProfile/userProfile");

        // get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // create user object from user whose profile page is being viewed
        User user = userDao.findById(id);
        response.addObject("user", user);

        // retrieve user session information (from user whose profile page is displayed)
        // to display on profile page and create user session object
        List<UserSession> us = userSessionDao.findByUserId(user.getId());
        response.addObject("userSession", us);


        // the following code below is redundant in some areas, but it used to ensure the
        // follow/unfollow mechanic is working properly
        // the code below is used to check if current user is the same as the user whose profile
        // is currently being viewed. if the users match, it will display "This is you!" on the profile
        // and will not give user the option to add themselves

        // creates authenticated user object
        User user2 = userDao.findByUsername(currentUserName);
        Integer userId2 = user2.getId();
        response.addObject("user2", userId2);

        // create user object of user whose profile is currently being viewed
        User user1 = userDao.findById(id);
        Integer userId1 = user1.getId();
        response.addObject("user1", userId1);

        // creates following object, which is picks which option to displa on profile (to follow or unfollow)
        // and tell the user whether they are following or not following the user whose page they are
        // viewing
        Following exists = followingDao.findByUserIdAndFollowingId(userId2, id);
        if (exists != null) {
            boolean following = true;
            response.addObject("exists", following);
        }
        if (exists == null) {
            boolean following = false;
            response.addObject("exists", following);
        }

        return response;
    }

}