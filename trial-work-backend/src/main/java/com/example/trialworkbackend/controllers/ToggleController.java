package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Toggle;
import com.example.trialworkbackend.repositories.ToggleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToggleController {

    private final ToggleRepository toggleRepository;

    public ToggleController(ToggleRepository toggleRepository) {
        this.toggleRepository = toggleRepository;
    }

    @GetMapping("/toggles")
    public List<Toggle> getToggles() {
        return (List<Toggle>) toggleRepository.findAll();
    }

    @PostMapping("/toggles")
    void addToggle(@RequestBody Toggle toggle) {
        toggleRepository.save(toggle);
    }
}
