package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionDAO extends JpaRepository<Session, Long> {

    @Query ("SELECT s FROM Session s")
    List<Session> getAllSessions();
}
