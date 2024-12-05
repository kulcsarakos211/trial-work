package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { }
