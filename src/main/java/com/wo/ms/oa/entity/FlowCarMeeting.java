package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "flow_car_meeting")
public class FlowCarMeeting  implements Serializable {
    /**
     * 流程id
     */
    @Id
    private Integer flowId;

    /**
     * 用车记录id
     */
    @Id
    private Integer useCarRecordId;

    /**
     * 会议记录id
     */
    @Id
    private Integer meetingId;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getUseCarRecordId() {
        return useCarRecordId;
    }

    public void setUseCarRecordId(Integer useCarRecordId) {
        this.useCarRecordId = useCarRecordId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }
}
