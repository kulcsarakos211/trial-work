package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Room;
import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.RoomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @PersistenceContext
    private EntityManager entityManager;

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @GetMapping(value = "/rooms", params = "userId")
    public List<Room> getRooms(@RequestParam("userId") long userId) {
        return roomRepository.findAllByUserId(userId);
    }

    @PostMapping("/rooms")
    void addRoom(@RequestBody Room room) {
        roomRepository.save(room);
    }
}
