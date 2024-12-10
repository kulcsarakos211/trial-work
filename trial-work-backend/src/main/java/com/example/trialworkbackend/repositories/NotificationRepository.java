package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.recipient.id = ?1")
    List<Notification> getAllByUserId(long id);
}
