package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 信息、公告
 */
@Entity(name = "oa_info")
public class OaInfo extends BaseEntity {
    /**
     * 标题
     */
    @Column(length = 50)
    private String infoTitle;

    /**
     * 发布人Id
     */
    private Integer publishId;

    /**
     * 组织Id
     */
    private Integer orgId;

    /**
     * 消息类型
     * 部门消息、全体公告、系统通知
     */
    private String infoType;

    /**
     * 是否重要
     * 1.一般 2.重要 3.紧急
     */
    private Integer important;

    /**
     * 内容
     */
    @Column(length = 8000)
    private String content;

    /**
     * 状态
     * 0.草稿 1.已发布
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Integer delFlg;

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getImportant() {
        return important;
    }

    public void setImportant(Integer important) {
        this.important = important;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }
}
