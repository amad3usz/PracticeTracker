package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FollowingDAO extends JpaRepository<Following, Long> {
    Following findByUserId(@Param("userId") Integer userId);

    Following findByFollowingId(@Param("followingId") Integer followingId);
//
//    List<User> getFollowingList(Integer userId);

    Following findByUserIdAndFollowingId(@Param("userId") Integer userId, @Param("followingId") Integer followingId);

}
