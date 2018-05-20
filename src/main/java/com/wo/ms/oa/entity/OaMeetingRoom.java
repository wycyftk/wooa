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

    /**
     * 会议室大小
     * 1. 1-9人 2.10-29人 3.30-49人 4.50人以上
     */
    private Integer size;

    /**
     * 会议室状态
     * 0.可用 1.使用中 2.不可用
     */
    private Integer status;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}
