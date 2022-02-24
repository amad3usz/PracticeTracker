package org.perscholas.practicetracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDAOTests {
    @Autowired
    UserDAO userDao;

    @Test
    public void testFindById() {
        // test to see if find by id is able to find user in database based on id
        User actualOutput = userDao.findById(9);
        Assertions.assertThat(actualOutput.getUsername()).isEqualTo("TroyMoy8");

    }

    @Test
    public void testFindByUsername() {
        // test to see if find by username is able to find user in database based on username
        User actualOutput = userDao.findByUsername("TroyMoy8");
        Assertions.assertThat(actualOutput.getId()).isEqualTo(9);

    }

    @Test
    public void testFindUsersByFirstLastAndUserName() {
        // test to see if input returns a result of a username and first name that exists in database
        List<User> actualOutput = userDao.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrUsernameContainingIgnoreCase("amadeusz", "amadeusz", "amadeusz");
        Assertions.assertThat(actualOutput.size()).isGreaterThan(0);

    }
}
