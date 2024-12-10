package com.example.trialworkbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "room_toggles")
@IdClass(RoomTogglesId.class)
public class RoomToggles {

    @Id
    @Column(name = "identifier", nullable = false)
    private String identifier;

    @Id
    @Column(name = "room_id", nullable = false)
    private long roomId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private boolean state;

    public RoomToggles() {
        this.identifier = "";
        this.roomId = 0;
        this.name = "";
        this.description = "";
        this.state = false;
    }
}
