package com.wo.ms.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "user_and_info")
public class UserAndInfo implements Serializable {
    @Id
    private Integer userId;

    @Id
    private Integer infoId;


    /**
     * 是否已读
     * 0.未读 1.已读
     */
    private Integer hasRead;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getHasRead() {
        return hasRead;
    }

    public void setHasRead(Integer hasRead) {
        this.hasRead = hasRead;
    }
}
