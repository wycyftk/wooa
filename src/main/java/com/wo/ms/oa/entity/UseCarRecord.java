package com.wo.ms.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用车记录
 */
@Entity(name = "use_car_record")
public class UseCarRecord extends BaseEntity {
    /**
     * 车id
     */
    private Integer carId;

    /**
     * 车名
     */
    private String carName;

    /**
     * 用车状态
     * 0.未使用 1.已使用 2.审批中
     */
    private Integer carStatus;

    /**
     * 用车原因
     */
    private String reason;

    private Date startTime;

    private Date endTime;

    public Integer getCarId() {
        return carId;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
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
