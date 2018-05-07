package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaMenu;
import java.util.List;

public class OaMenuPagtionDto {
    private List<OaMenu> menuList;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;

    public List<OaMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<OaMenu> menuList) {
        this.menuList = menuList;
    }

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
}
