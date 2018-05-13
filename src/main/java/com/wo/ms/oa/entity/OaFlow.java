package com.wo.ms.oa.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "oa_flow")
public class OaFlow extends BaseEntity{
    /**
     * 流程名称
     */
    private String flowName;

    /**
     * 发起人id
     */
    private Integer launchId;

    /**
     * 发起人名称
     */
    private String launchName;

    /**
     * 审批人id
     */
    private Integer approvalId;

    /**
     * 审批人名称
     */
    private String approvalName;

    /**
     * 备注
     */
    private String note;

    /**
     * 审批意见
     * 0.同意 1.驳回
     */
    private Integer opinion;

    /**
     * 状态
     * 1.草稿 2.已提交 3.部长审批 4.管理员审批 5.总经理审批 0.审批完成
     */
    private Integer status;

    public Integer getOpinion() {
        return opinion;
    }

    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Integer getLaunchId() {
        return launchId;
    }

    public void setLaunchId(Integer launchId) {
        this.launchId = launchId;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

}
