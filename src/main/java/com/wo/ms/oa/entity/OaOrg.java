package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "oa_org")
public class OaOrg extends BaseEntity{
    private String orgName;

    @Column(length = 20)
    private String descrition;

    @Column(length = 20)
    private Integer leftNode;

    @Column(length = 20)
    private Integer rightNode;

    private Integer orgLevel;

    private Integer delFlg;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Integer getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Integer leftNode) {
        this.leftNode = leftNode;
    }

    public Integer getRightNode() {
        return rightNode;
    }

    public void setRightNode(Integer rightNode) {
        this.rightNode = rightNode;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }
}
