package org.perscholas.practicetracker.security;

import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//majority of code by Eric Heilig
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // user by username and create user object
        User user = userDao.findByUsername(username);

        // if user doesn't exist, throw UsernameNotFoundException
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // retrieve user role based on user id
        List<UserRole> userRoles = userDao.getUserRoles(user.getId());
        // gives authority based on user role
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        // returns authenticated user (including user role(s)
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), springRoles);
    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole().toString()));
        }

        return authorities;
    }
}
