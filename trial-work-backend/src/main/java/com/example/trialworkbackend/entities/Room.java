package com.example.trialworkbackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "members",
            joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    )
    private List<User> members;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "room_toggles",
            joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "identifier", referencedColumnName = "identifier")
    )
    private List<Toggle> toggles;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "room")
    private List<Message> messages;

    public Room() {
        id = 0;
        owner = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "This chatroom is owner by " + owner.getUsername();
    }
}
