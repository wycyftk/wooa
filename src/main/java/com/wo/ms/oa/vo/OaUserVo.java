package com.wo.ms.oa.vo;

import com.wo.ms.oa.entity.OaUser;

import java.util.List;

public class OaUserVo {
    private List<OaUser> userList;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;

    public List<OaUser> getUserList() {
        return userList;
    }

    public void setUserList(List<OaUser> userList) {
        this.userList = userList;
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
