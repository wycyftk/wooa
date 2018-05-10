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
     * 意见
     */
    private String approvalIdea;

    /**
     * 审批意见
     * 0.同意 1.驳回
     */
    private Integer status;

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public String getApprovalIdea() {
        return approvalIdea;
    }

    public void setApprovalIdea(String approvalIdea) {
        this.approvalIdea = approvalIdea;
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
