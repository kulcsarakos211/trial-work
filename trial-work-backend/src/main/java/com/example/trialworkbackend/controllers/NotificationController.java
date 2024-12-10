package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Notification;
import com.example.trialworkbackend.repositories.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {

    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/notifications/{id}")
    public List<Notification> getMessagesByUserId(@PathVariable long id) {
        return notificationRepository.getAllByUserId(id);
    }

    @PostMapping("/notifications")
    void addMessage(@RequestBody Notification notification) {
        notificationRepository.save(notification);
    }
}
