package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.UseCarRecord;

import java.util.List;

public class UseCarRecordPagtion {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private List<UseCarRecord> useCarRecordList;

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

    public List<UseCarRecord> getUseCarRecordList() {
        return useCarRecordList;
    }

    public void setUseCarRecordList(List<UseCarRecord> useCarRecordList) {
        this.useCarRecordList = useCarRecordList;
    }
}
