package org.perscholas.practicetracker.controller;

import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.registerForm.RegisterFormBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/editUserList")
public class EditUserController {
    @Autowired
    private UserDAO userDao;

    public static final Logger LOG = LoggerFactory.getLogger(UserListController.class);

    //if it is called without an id it will be a create
    //if using id it will be an update
    @RequestMapping(value = "/registerEdit", method = RequestMethod.GET) //!!!!!!!!Create a new page
    public ModelAndView userList(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");


        if ( id != null) {
            //id has been passed so it is an update
            //prepopulates form so you can edit the current values
           User user = userDao.findById(id);
            RegisterFormBean form = new RegisterFormBean();
            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setPassword(user.getPassword());
            form.setConfirmPassword(user.getConfirmPassword());
            form.setId(user.getId());

            response.addObject("form", form); //formbeankey in example

        } else {
            //id has not been passed so it is a create
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("form", form);
        }
        return response;
    }
}
