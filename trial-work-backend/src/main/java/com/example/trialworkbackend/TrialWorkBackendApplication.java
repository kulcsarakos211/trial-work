package com.example.trialworkbackend;

import com.example.trialworkbackend.entities.Room;
import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.RoomRepository;
import com.example.trialworkbackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class TrialWorkBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrialWorkBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, RoomRepository roomRepository) {
        return args -> {
            userRepository.findAll().forEach(System.out::println);
            roomRepository.findAll().forEach(System.out::println);
        };
    }
}
