package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("SELECT u.memberships FROM User u WHERE u.id = ?1")
    List<Room> findAllByUserId(long id);
}
