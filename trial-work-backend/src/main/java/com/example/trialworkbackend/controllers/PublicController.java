package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.ApiKey;
import com.example.trialworkbackend.entities.RoomToggles;
import com.example.trialworkbackend.repositories.ApiKeyRepository;
import com.example.trialworkbackend.repositories.RoomTogglesRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PublicController {

    private final RoomTogglesRepository roomTogglesRepository;
    private final ApiKeyRepository apiKeyRepository;

    public PublicController(RoomTogglesRepository roomTogglesRepository, ApiKeyRepository apiKeyRepository) {
        this.roomTogglesRepository = roomTogglesRepository;
        this.apiKeyRepository = apiKeyRepository;
    }

    @GetMapping("/api/{id}")
    public List<RoomToggles> getRoomToggles(@PathVariable("id") long id, @RequestHeader(name = "X-Api-Key") String apiKey, HttpServletResponse response) {
        ApiKey apiKey1 = apiKeyRepository.findById(apiKey).orElse(null);
        if (apiKey1 == null || apiKey1.getExpiration().compareTo(LocalDateTime.now().toString()) < 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        return roomTogglesRepository.getAllActiveByRoomId(id);
    }
}
