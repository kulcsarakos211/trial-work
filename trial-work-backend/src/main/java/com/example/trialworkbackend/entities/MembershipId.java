package com.example.trialworkbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MembershipId {

    @Column(name = "user_id")
    private long userId;

    @Column(name = "room_id")
    private long roomId;

    public MembershipId(long userId, long roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    public MembershipId() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
        result = prime * result + (int) userId;
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
        MembershipId other = (MembershipId) obj;
        if (roomId != other.roomId) {
            return false;
        }
        if (userId != other.userId) {
            return false;
        }
        return true;
    }
}
