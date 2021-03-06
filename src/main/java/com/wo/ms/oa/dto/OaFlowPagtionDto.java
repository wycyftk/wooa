package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaFlow;
import com.wo.ms.oa.entity.OaMeeting;

import java.util.List;
import java.util.Map;

public class OaFlowPagtionDto {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private List<OaFlow> flowList;
    private List<Map<String, Object>> flowInfo;

    public List<Map<String, Object>> getFlowInfo() {
        return flowInfo;
    }

    public void setFlowInfo(List<Map<String, Object>> flowInfo) {
        this.flowInfo = flowInfo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<OaFlow> getFlowList() {
        return flowList;
    }

    public void setFlowList(List<OaFlow> flowList) {
        this.flowList = flowList;
    }
}
