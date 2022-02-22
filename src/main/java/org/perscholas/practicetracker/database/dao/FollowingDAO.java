package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface FollowingDAO extends JpaRepository<Following, Long> {

    Following findByUserIdAndFollowingId(@Param("userId") Integer userId, @Param("followingId") Integer followingId);

    @Query(value = "SELECT f.*, username, skills_practicing, profile_icon from PracticeTracker.following f Left Join PracticeTracker.users u ON f.following_id = u.id Where f.user_id = :userId ", nativeQuery = true)
    List<Map<String,Object>> findAllWithDescriptionQuery(@Param("userId") Integer userId);
}
