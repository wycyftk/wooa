package com.wo.ms.oa.vo;

import com.wo.ms.oa.entity.OaRole;

import java.util.List;

public class OaRoleVo {
    private List<OaRole> roleList;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;

    public List<OaRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<OaRole> roleList) {
        this.roleList = roleList;
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
}
