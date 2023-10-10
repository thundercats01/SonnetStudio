package com.example.lyricalapes.repositories;

import com.example.lyricalapes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    @Query("SELECT u.username FROM User u WHERE u.username LIKE :query%")
//    List<String> findUsernamesByQuery(@Param("query") String query);

    List<User> findByUsernameContainingIgnoreCase(String username);

}
