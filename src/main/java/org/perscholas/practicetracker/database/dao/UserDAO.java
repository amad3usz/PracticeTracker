package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.User;
import org.perscholas.practicetracker.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);

    User findByUsername(@Param("username") String username);

    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrUsernameContainingIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username);

    @Query("SELECT ur FROM UserRole ur WHERE ur.user.id = :userId")
    List<UserRole> getUserRoles(Integer userId);
}
