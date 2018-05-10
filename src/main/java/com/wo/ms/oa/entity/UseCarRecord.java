package com.wo.ms.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用车记录
 */
@Entity(name = "use_car_record")
public class UseCarRecord implements Serializable {
    @Id
    private Integer carId;

    @Id
    private Integer flowId;

    private String carName;
    /**
     * 流程状态
     * 0.流程结束 1.第一节点，部长审批 2.第二节点，车辆管理员 3.总经理审批
     */
    private Integer flowStatus;

    private String reason;

    private Date startTime;

    private Date endTime;

    public Integer getCarId() {
        return carId;
    }

    public String getReason() {
        return reason;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Integer flowStatus) {
        this.flowStatus = flowStatus;
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
}
