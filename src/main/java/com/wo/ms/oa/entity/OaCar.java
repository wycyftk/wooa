package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 车辆实体
 */
@Entity(name = "oa_car")
public class OaCar extends BaseEntity {
    /**
     * 车辆名称
     */
    @Column(length = 20)
    private String carName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 状态
     */
    private Integer status;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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
