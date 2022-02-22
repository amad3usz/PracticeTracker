package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserSessionDAO extends JpaRepository<UserSession, Long> {

    UserSession findById(@Param("id") Integer id);

    @Query("SELECT us FROM UserSession us WHERE us.user.id = :userId")
    List<UserSession> findByUserId(@Param("userId") Integer userId);

    List<UserSession> findByUserIdOrderByDateDesc(@Param("userId") Integer userId);

    @Query(value = "SELECT us.*, session_type from PracticeTracker.user_sessions us Left Join PracticeTracker.sessions s ON us.session_id = s.session_id Where us.user_id = :userId ORDER BY us.date DESC ", nativeQuery = true)
    List<Map<String, Object>> findAllWithDescriptionQuery(@Param("userId") Integer userId);

}