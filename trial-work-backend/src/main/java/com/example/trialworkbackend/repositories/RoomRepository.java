package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Room;
import com.example.trialworkbackend.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("SELECT r FROM Room r, Membership m, User u WHERE m.user.id = ?1")
    List<Room> findAllByUserId(long id);

    @Query("SELECT r FROM Room r WHERE r.id = ?1")
    Room findById(long id);
}
