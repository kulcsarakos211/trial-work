package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.ApiKey;
import com.example.trialworkbackend.repositories.ApiKeyRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApiKeyController {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyController(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @GetMapping(value = "/apikey")
    public ApiKey create() {
        ApiKey apiKey = new ApiKey();
        apiKey.setValue(UUID.randomUUID().toString());
        apiKey.setExpiration(LocalDateTime.now().plusWeeks(1).toString());
        return apiKeyRepository.save(apiKey);
    }
}
