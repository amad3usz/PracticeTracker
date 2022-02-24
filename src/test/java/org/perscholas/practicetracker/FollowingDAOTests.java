package org.perscholas.practicetracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.practicetracker.database.dao.FollowingDAO;
import org.perscholas.practicetracker.database.entity.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FollowingDAOTests {
    @Autowired
    FollowingDAO followingDao;

    @Test
    public void testFindByUserIdAndFollowingId() {
        //tests to find if user and following user exist in database
        Following expectedOutput = new Following();
        expectedOutput.setId(105);
        expectedOutput.setUserId(9);
        expectedOutput.setFollowingId(8);
        Following actualOutput = followingDao.findByUserIdAndFollowingId(9, 8);
        assertThat(actualOutput)
                .usingRecursiveComparison()
                .isEqualTo(expectedOutput);

    }

    @Test
    public void testFindFollowingUserWithInformation() {
        // test if list of user, followed users, and followed users information exists
        List<Map<String,Object>> actualOutput = followingDao.findAllWithDescriptionQuery(9);
        Assertions.assertThat(actualOutput.size()).isGreaterThan(0);

    }
}
