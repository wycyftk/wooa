package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 组织
 */
@Entity(name = "oa_org")
public class OaOrg extends BaseEntity{
    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 描述
     */
    @Column(length = 20)
    private String descrition;

    /**
     * 左节点值
     */
    @Column(length = 20)
    private Integer leftNode;

    /**
     * 右节点值
     */
    @Column(length = 20)
    private Integer rightNode;

    /**
     * 组织等级
     */
    private Integer orgLevel;

    /**
     * 删除标记
     */
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
