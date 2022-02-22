package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.FollowingFormBean.FollowingBean;
import org.perscholas.practicetracker.database.dao.FollowingDAO;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.dao.UserSessionDAO;
import org.perscholas.practicetracker.database.entity.Following;
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
import java.util.Map;

@Controller
public class FollowingController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private FollowingDAO followingDao;

    @Autowired
    private UserSessionDAO userSessionDao;

    @RequestMapping(value = "/user/followingList", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView followingList() {
        ModelAndView response = new ModelAndView();
        response.setViewName("followingList/followingList");

        // retrieve authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // add current user object
        User user = userDao.findByUsername(currentUserName);
        response.addObject("user", user);

        // retrieve joined table with user id, following id,
        // and a few stats of followed users to populate list of users followed and add following object
        List<Map<String,Object>> following = followingDao.findAllWithDescriptionQuery(user.getId());
        response.addObject("following", following);

        return response;
    }


        @RequestMapping(value = "/user/follow", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView follow(@ModelAttribute("following") @Valid FollowingBean followingBean, @RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView();
        String url = "redirect:/user/profile?id=" + id;

        // redirects user back to user profile page after following that user
        response.setViewName(url);

        // retrieve authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // add current user object
        User user = userDao.findByUsername(currentUserName);

        // add user2 object whose profile page is being viewed
        User user2 = userDao.findById(id);
        response.addObject("user", user2);

        // retrieve user2's information to display on their profile page
        List<UserSession> us = userSessionDao.findByUserId(user2.getId());
        response.addObject("userSession", us);

        // get id from authenticated user
        Integer userId = user.getId();

        //add new combination of user and following user to database
        Following following = new Following();

        following.setUserId(userId);
        following.setFollowingId(id);

        // checks if the relationship between user and following user exists
        Following exists = followingDao.findByUserIdAndFollowingId(userId, id);
        // if relationship doesn't exist, add new relationship to the following table
        if (exists == null) {
            boolean follow = true;
            // pass follow object to display whether user is following or not following the user whose profile page they are visiting
            response.addObject("exists", follow);
            // adds relationship
            followingDao.save(following);
        }

        return response;
    }

    @RequestMapping(value = "/user/unfollow", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView unfollow(@ModelAttribute("following") @Valid FollowingBean followingBean, @RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView();
        String url = "redirect:/user/profile?id=" + id;
        // redirects user back to user profile page after unfollowing that user
        response.setViewName(url);

        // retrieve authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // add current user object
        User user = userDao.findByUsername(currentUserName);

        // add user2 whose profile page is being viewed
        User user2 = userDao.findById(id);
        response.addObject("user", user2);

        // retrieve user2's information to display on their profile page
        List<UserSession> us = userSessionDao.findByUserId(user2.getId());
        response.addObject("userSession", us);

        // get id from authenticated user
        Integer userId = user.getId();

        // checks if the relationship between user and following user exists
        Following exists = followingDao.findByUserIdAndFollowingId(userId, id);
        // if relationship does exist, delete relationship from the following table
        if (exists != null) {
            boolean follow = false;
            // pass follow object to display whether user is following or not following the user whose profile page they are visiting
            response.addObject("exists", follow);
            // deletes relationship
            followingDao.delete(exists);
        }

        return response;
    }
}
