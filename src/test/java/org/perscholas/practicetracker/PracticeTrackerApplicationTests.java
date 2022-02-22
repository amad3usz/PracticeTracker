package org.perscholas.practicetracker;

import org.junit.jupiter.api.Test;
import org.perscholas.practicetracker.database.dao.*;
import org.perscholas.practicetracker.database.entity.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PracticeTrackerApplicationTests {
    @Autowired
    FollowingDAO followingDao;

    @Autowired
    SessionDAO sessionDAO;

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDao;

    @Autowired
    UserSessionDAO userSessionDao;

    @Test
    public void testFindByUserIdAndFollowingId() {
        Following expectedOutput = new Following();
        expectedOutput.setId(105);
        expectedOutput.setUserId(9);
        expectedOutput.setFollowingId(8);
        Following actualOutput = followingDao.findByUserIdAndFollowingId(9, 8);
        assertThat(actualOutput)
                .usingRecursiveComparison()
                .isEqualTo(expectedOutput);

    }

//    public void testFindAllWithDescriptionQuery() {
//        List<Map<String,Object>> expectedOutput = new ;
//        expectedOutput = followingDao.findAllWithDescriptionQuery(9);
//
//        List<Map<String, Object>> actualOutput = followingDao.findAllWithDescriptionQuery(9);
//        assertThat(actualOutput)
//                .usingRecursiveComparison()
//                .isEqualTo(expectedOutput);
//    }


}
