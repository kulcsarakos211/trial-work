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
    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }
}
