package org.perscholas.practicetracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.practicetracker.database.dao.SessionDAO;
import org.perscholas.practicetracker.database.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SessionDAOTests {
    @Autowired
    SessionDAO sessionDao;

    @Test
    public void testGetAllSessionsList() {
        // test to see if list of all 8 sessions is retrieved
        List<Session> actualOutput = sessionDao.getAllSessions();
        Assertions.assertThat(actualOutput.size()).isEqualTo(8);

    }
}
