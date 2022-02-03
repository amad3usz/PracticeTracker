package org.perscholas.practicetracker.database.dao;

import org.perscholas.practicetracker.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    public List<User> findByLastName(@Param("lastName") String lastName);

//    @Query ("SELECT u FROM User u WHERE u.firstName = :firstName or u.lastName = :lastName")
    public List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrUsernameContainingIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public List<User> findByUsername(@Param("username") String username);


//    don't really need
//    @Query("SELECT ur FROM UserRole ur WHERE ur.user.id = :userId")
//    List<UserRole> getUserRoles(Integer userId);
}
