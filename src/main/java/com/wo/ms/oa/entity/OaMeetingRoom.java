package com.wo.ms.oa.entity;

import javax.persistence.Entity;

/**
 * 会议室
 */
@Entity(name = "oa_meeting_room")
public class OaMeetingRoom extends BaseEntity {
    /**
     * 会议室名称
     */
    private String meetingRoom;

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}
