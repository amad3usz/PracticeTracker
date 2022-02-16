package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface FollowingDAO extends JpaRepository<Following, Long> {

//
//    List<User> findById(@Param("following") Following following);
//    List<Following> findByUserId(@Param("userId") Integer userId);

    Following findByUserIdAndFollowingId(@Param("userId") Integer userId, @Param("followingId") Integer followingId);

    @Query(value = "SELECT f.*, username, skills_practicing, profile_icon from PracticeTracker.following f Left Join PracticeTracker.users u ON f.following_id = u.id Where f.user_id = :userId ", nativeQuery = true)
    List<Map<String,Object>> findAllWithDescriptionQuery(@Param("userId") Integer userId);
//    @Query ("SELECT * from PracticeTracker.user_sessions us Left Join PracticeTracker.sessions s ON us.session_id = s.session_id Where us.user_id = :id")
//    List<Following> FindAllWithDescriptionQuery(@Param("followingId") Integer);
}
