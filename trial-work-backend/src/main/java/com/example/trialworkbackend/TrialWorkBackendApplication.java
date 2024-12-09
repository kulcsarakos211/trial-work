package com.example.trialworkbackend;

import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class TrialWorkBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrialWorkBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
