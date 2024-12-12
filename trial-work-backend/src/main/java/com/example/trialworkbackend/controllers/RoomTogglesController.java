package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.RoomToggles;
import com.example.trialworkbackend.repositories.RoomTogglesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomTogglesController {

    private final RoomTogglesRepository roomTogglesRepository;

    public RoomTogglesController(RoomTogglesRepository roomTogglesRepository) {
        this.roomTogglesRepository = roomTogglesRepository;
    }

    @GetMapping(value = "/room/toggles", params = "id")
    public List<RoomToggles> getRoomTogglesByRoomId(@RequestParam("id") long id) {
        return roomTogglesRepository.getAllByRoomId(id);
    }

    @PostMapping("/room/toggles")
    void addRoomToggles(@RequestBody RoomToggles roomToggles) {
        roomTogglesRepository.save(roomToggles);
    }
}
