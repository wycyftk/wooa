package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaMeeting;

import java.util.List;

public class OaMeetingPagtion {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private List<OaMeeting> oaMeetingList;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<OaMeeting> getOaMeetingList() {
        return oaMeetingList;
    }

    public void setOaMeetingList(List<OaMeeting> oaMeetingList) {
        this.oaMeetingList = oaMeetingList;
    }
}
