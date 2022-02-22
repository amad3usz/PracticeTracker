package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.database.dao.*;
import org.perscholas.practicetracker.database.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TESTINGController {
    @Autowired
    FollowingDAO followingDao;

    @Autowired
    SessionDAO sessionDao;

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDao;

    @Autowired
    UserSessionDAO userSessionDao;


    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public ModelAndView test() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("index/index");
        List<Map<String,Object>> following2 = followingDao.findAllWithDescriptionQuery(9);
        System.out.println(following2);

        List<Session> getAllSessions = sessionDao.getAllSessions();
        System.out.println(getAllSessions);

        return response;
    }


//    @Query(value = "SELECT f.*, username, skills_practicing, profile_icon from PracticeTracker.following f Left Join PracticeTracker.users u ON f.following_id = u.id Where f.user_id = :userId ", nativeQuery = true)
//    List<Map<String,Object>> findAllWithDescriptionQuery(@Param("userId") Integer userId);

}
