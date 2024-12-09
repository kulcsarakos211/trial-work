package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
