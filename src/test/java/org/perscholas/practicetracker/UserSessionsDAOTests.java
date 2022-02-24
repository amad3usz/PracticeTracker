package org.perscholas.practicetracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.practicetracker.database.dao.UserSessionDAO;
import org.perscholas.practicetracker.database.entity.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class UserSessionsDAOTests {

    @Autowired
    UserSessionDAO userSessionDao;
    
    @Test
    public void testFindUserSessionById() {
        // test to see if find by user session is able to find user session in database based on session name
        UserSession actualOutput = userSessionDao.findById(65);
        Assertions.assertThat(actualOutput.getSessionName()).isEqualTo("Journaling");

    }

    @Test
    public void testCreateUserSession() {
        UserSession expectedOutput = userSessionDao.findById(86);
        UserSession actualOutput = new UserSession();
        actualOutput.setSessionId(3);
        Assertions.assertThat(expectedOutput.getSessionId()).isEqualTo(actualOutput.getSessionId());
    }

    @Test
    @Rollback(value = false)
    public void testUpdateUserSessionById() {
        // test to see if user session is able to be updated (originally set to Journaling)
        UserSession actualOutput = userSessionDao.findById(65);
        actualOutput.setSessionName("Tinkering");
        userSessionDao.save(actualOutput);
//        System.out.println(userSessionDao.findById(65).getSessionName());
        Assertions.assertThat(userSessionDao.findById(65).getSessionName()).isEqualTo(actualOutput.getSessionName());

    }

    @Test
    @Rollback(value = false)
    public void testDeleteUserSessionById() {
        // test to see if able to delete usersession
        UserSession actualOutput = userSessionDao.findById(67);
        userSessionDao.delete(actualOutput);
        Optional<UserSession> optionalActualOutput = Optional.ofNullable(userSessionDao.findById(actualOutput.getId()));

        UserSession tempActualOutput = null;
        if (optionalActualOutput.isPresent()) {
            tempActualOutput = optionalActualOutput.get();
        }

        Assertions.assertThat(tempActualOutput).isNull();

    }



    @Test
    public void testIfUserSessionsExist() {
        // test if list of user sessions is retrieved
        List<UserSession> actualOutput = userSessionDao.findByUserId(9);
        Assertions.assertThat(actualOutput.size()).isGreaterThan(0);

    }

    @Test
    public void testIfUserSessionsExistOrderByDate() {
        // test if list of user sessions (by date) is retrieved
        List<UserSession> actualOutput = userSessionDao.findByUserIdOrderByDateDesc(9);
        Assertions.assertThat(actualOutput.size()).isGreaterThan(0);

    }

    @Test
    public void testIfUserSessionWithSessionTypeExists() {
        // test if list of user session info with session type name is retrieved
        List<Map<String, Object>> actualOutput = userSessionDao.findAllWithDescriptionQuery(9);
        Assertions.assertThat(actualOutput.size()).isGreaterThan(0);
    }
}
