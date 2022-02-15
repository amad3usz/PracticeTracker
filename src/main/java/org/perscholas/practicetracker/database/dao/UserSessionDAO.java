package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSessionDAO extends JpaRepository<UserSession, Long> {

    UserSession findById(@Param("id") Integer id);

    @Query("SELECT us FROM UserSession us WHERE us.userId = :userId")
    List<UserSession> findByUserId(@Param("userId") Integer userId);

    List<UserSession> findByUserIdOrderByDateDesc(@Param("userId") Integer userId);

    UserSession findBySessionId(Integer id);

    @Query(value = "SELECT us, s from UserSession us Left Join Session s ON us.sessionId = s.sessionId Where us.userId = :userId ")
    public List <UserSession> FindAllWithDescriptionQueryOrderByUserIdOrderByDateDesc(@Param("userId") Integer userId);


}
