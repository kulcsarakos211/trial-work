package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends org.springframework.data.repository.Repository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}