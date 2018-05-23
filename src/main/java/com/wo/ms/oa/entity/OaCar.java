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
     * 车的品牌
     */
    private String carBrand;

    /**
     * 车座数
     * 1. 4座 2.7座 3.9座 4.11座
     */
    private Integer carSeat;

    /**
     * 车牌号
     */
    private String carNum;

    /**
     * 车的状态
     * 0.可用 1.不可用
     */
    private Integer status;

    public Integer getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(Integer carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
