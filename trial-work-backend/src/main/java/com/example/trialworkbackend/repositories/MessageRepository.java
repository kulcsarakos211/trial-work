package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.room.id = ?1")
    List<Message> getAllByRoomId(long id);
}
