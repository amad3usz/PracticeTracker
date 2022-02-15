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

@Controller
public class FollowingController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private FollowingDAO followingDao;

    @Autowired
    private UserSessionDAO userSessionDao;

    @RequestMapping(value = "/user/follow", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView follow(@ModelAttribute("following") @Valid FollowingBean followingBean, @RequestParam(required = false) Integer id) {


        System.out.println(id);
        ModelAndView response = new ModelAndView();
        String url = "redirect:/user/profile?id=" + id;
        response.setViewName(url);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = userDao.findByUsername(currentUserName);


        User user2 = userDao.findById(id);
        response.addObject("user", user2);

        List<UserSession> us = userSessionDao.findByUserId(user2.getId());
        response.addObject("userSession", us);
        Integer userId = user.getId();
//        Integer followingId = id;

        Following following = new Following();

        following.setUserId(userId);
        following.setFollowingId(id);
        Following exists = followingDao.findByUserIdAndFollowingId(userId, id);
        if (exists == null) {
            boolean follow = true;
            response.addObject("exists", follow);
            followingDao.save(following);
        }
//        if (exists != null) {
//
//        }
//        if (exists == null) {
//            boolean follow = false;
//            response.addObject("exists", follow);
//        }
        return response;
    }

    @RequestMapping(value = "/user/unfollow", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView unfollow(@ModelAttribute("following") @Valid FollowingBean followingBean, @RequestParam(required = false) Integer id) {


        ModelAndView response = new ModelAndView();
        String url = "redirect:/user/profile?id=" + id;
        response.setViewName(url);
        User user2 = userDao.findById(id);
        response.addObject("user", user2);

        List<UserSession> us = userSessionDao.findByUserId(user2.getId());
        response.addObject("userSession", us);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = userDao.findByUsername(currentUserName);
        Integer userId = user.getId();

        Following exists = followingDao.findByUserIdAndFollowingId(userId, id);
        if (exists != null) {
            boolean follow = false;
            response.addObject("exists", follow);
            followingDao.delete(exists);

        }
//        if (exists != null) {
//
//        }
//        if (exists == null) {
//            boolean follow = false;
//            response.addObject("exists", follow);
//        }

        return response;
    }
}
