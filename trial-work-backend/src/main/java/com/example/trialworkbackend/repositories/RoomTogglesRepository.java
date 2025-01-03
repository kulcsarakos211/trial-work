package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.RoomToggles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTogglesRepository extends CrudRepository<RoomToggles, Integer> {

    @Query("SELECT rt FROM RoomToggles rt WHERE rt.roomId = ?1 AND rt.state = true")
    List<RoomToggles> getAllActiveByRoomId(long id);

    @Query("SELECT rt FROM RoomToggles rt WHERE rt.roomId = ?1")
    List<RoomToggles> getAllByRoomId(long id);
}
