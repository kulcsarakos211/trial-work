package com.example.trialworkbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class RoomTogglesId {

    private String identifier;
    private long roomId;

    public RoomTogglesId() {}

    public RoomTogglesId(String identifier, long roomId) {
        this.identifier = identifier;
        this.roomId = roomId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) roomId;
        result = prime * result + (identifier == null ? 0  : identifier.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RoomTogglesId other = (RoomTogglesId) obj;
        if (roomId != other.roomId) {
            return false;
        }
        if (identifier == null) {
            return other.identifier == null;
        } else {
            return identifier.equals(other.identifier);
        }
    }
}
