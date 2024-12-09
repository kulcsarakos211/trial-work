package com.example.trialworkbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private User owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Room() {
        id = 0;
        owner = null;
    }

    @Override
    public String toString() {
        return "This chatroom is owner by " + owner.getUsername();
    }
}
