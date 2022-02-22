package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

}