package org.perscholas.practicetracker.controller;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserListController {
    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userList/userList");

        // search function to find user by part of username, firstname, and lastname
        if ( ! StringUtils.isEmpty(search)) {
            List<User> users = userDao.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrUsernameContainingIgnoreCase(search, search, search);

            // adds list of users object that match search query
            response.addObject("userListKey", users);
            // adds search input into the query
            response.addObject("searchInput", search);
        }
        return response;
    }
}
