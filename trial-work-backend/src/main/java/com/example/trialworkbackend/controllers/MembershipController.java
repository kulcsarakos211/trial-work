package com.example.trialworkbackend.controllers;

import com.example.trialworkbackend.entities.Membership;
import com.example.trialworkbackend.entities.Room;
import com.example.trialworkbackend.entities.User;
import com.example.trialworkbackend.repositories.MembershipRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MembershipController {

    private final MembershipRepository membershipRepository;

    public MembershipController(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @PostMapping(value = "/memberships", params = "roomId")
    void addUserToRoom(@RequestBody User user, @RequestParam("roomId") long roomId) {
        Room room = new Room();
        room.setId(roomId);
        Membership membership = new Membership();
        membership.setUser(user);
        membership.setRoom(room);
        membershipRepository.save(membership);
    }
}
