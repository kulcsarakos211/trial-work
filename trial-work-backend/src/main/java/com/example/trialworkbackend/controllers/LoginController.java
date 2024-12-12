package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.LoginRepository;
import com.example.trialworkbackend.repositories.UserRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User existingUser = loginRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return null;
        }
        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return existingUser;
        }
        return null;
    }
}
