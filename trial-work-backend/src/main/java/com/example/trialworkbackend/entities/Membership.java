package com.example.trialworkbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Membership {

    @EmbeddedId
    private MembershipId id = new MembershipId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Membership() {
    }

    public Membership(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUserRoom(User user, Room room) {
        this.user = user;
        this.room = room;

        user.getMemberships().add(this);
        room.getMembers().add(this);
    }
}
