package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findById(long id);

    @Modifying
    @Query("UPDATE User u SET u.username = ?2, u.password = ?3, u.firstLogin = ?4 WHERE u.id = ?1")
    void updateUser(long id, String username, String password, boolean firstLogin);
}
