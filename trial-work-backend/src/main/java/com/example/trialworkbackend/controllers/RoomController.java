package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Room;
import com.example.trialworkbackend.repositories.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @PostMapping("/rooms")
    void addRoom(@RequestBody Room room) {
        roomRepository.save(room);
    }
}
