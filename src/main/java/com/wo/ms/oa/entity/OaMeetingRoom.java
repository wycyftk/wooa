package com.wo.ms.oa.entity;

import javax.persistence.Entity;

@Entity(name = "oa_meeting_room")
public class OaMeetingRoom extends BaseEntity {
    private String meetingRoom;

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}
