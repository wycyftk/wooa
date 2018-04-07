package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 会议
 */
@Entity(name = "oa_meeting")
public class OaMeeting extends BaseEntity {
    /**
     * 会议名称
     */
    @Column(length = 50)
    private String meetingName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 会议状态
     */
    private Integer status;

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
