package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.RoomToggles;
import com.example.trialworkbackend.repositories.RoomTogglesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicController {

    private final RoomTogglesRepository roomTogglesRepository;

    public PublicController(RoomTogglesRepository roomTogglesRepository) {
        this.roomTogglesRepository = roomTogglesRepository;
    }

    @GetMapping("/api/{id}")
    public List<RoomToggles> getRoomToggles(@PathVariable("id") long id) {
        return roomTogglesRepository.getAllByRoomId(id);
    }
}
