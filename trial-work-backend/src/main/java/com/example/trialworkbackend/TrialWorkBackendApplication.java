package com.example.trialworkbackend;

import com.example.trialworkbackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class TrialWorkBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrialWorkBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, RoomRepository roomRepository, NotificationRepository notificationRepository, RoomTogglesRepository roomTogglesRepository, ToggleRepository toggleRepository) {
        return args -> {
        };
    }
}
