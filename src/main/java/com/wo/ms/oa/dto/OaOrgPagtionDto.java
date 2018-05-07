package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaOrg;
import java.util.List;

public class OaOrgPagtionDto {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private List<OaOrg> orgList;

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

    public List<OaOrg> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OaOrg> orgList) {
        this.orgList = orgList;
    }
}
