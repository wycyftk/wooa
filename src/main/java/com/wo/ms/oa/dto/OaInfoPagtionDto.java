package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaInfo;

import java.util.List;

public class OaInfoPagtionDto {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private List<OaInfo> infoList;

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

    public List<OaInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<OaInfo> infoList) {
        this.infoList = infoList;
    }
}
