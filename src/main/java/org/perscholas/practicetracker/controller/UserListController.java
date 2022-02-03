package org.perscholas.practicetracker.controller;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/userList")
public class UserListController {
    @Autowired
    private UserDAO userDao;

    public static final Logger LOG = LoggerFactory.getLogger(UserListController.class);

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userList/userList");

        LOG.debug("debug message!");
        if ( ! StringUtils.isEmpty(search)) {
            List<User> users = userDao.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrUsernameContainingIgnoreCase(search, search, search);

            response.addObject("userListKey", users);
            response.addObject("searchInput", search);
        }
        return response;
    }
}
