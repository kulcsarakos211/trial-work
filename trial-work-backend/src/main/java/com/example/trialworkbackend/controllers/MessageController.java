package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Message;
import com.example.trialworkbackend.repositories.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping(value = "/messages", params = "id")
    public List<Message> getMessagesByRoomId(@RequestParam("id") long id) {
        return messageRepository.getAllByRoomId(id);
    }

    @PostMapping("/messages")
    void addMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }
}
