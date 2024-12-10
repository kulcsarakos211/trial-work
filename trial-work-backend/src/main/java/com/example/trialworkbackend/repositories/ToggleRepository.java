package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Toggle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToggleRepository extends CrudRepository<Toggle, String> {
}
