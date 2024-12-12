package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(value = "/users", params = "email")
    public User getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping(value = "/users", params = "username")
    public User getUserByUsername(@RequestParam String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping(value = "/users", params = "id")
    public User getUserById(@RequestParam long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @PatchMapping("/users")
    void updateUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.updateUser(user.getId(), user.getUsername(), user.getPassword(), user.isFirstLogin());
    }
}

