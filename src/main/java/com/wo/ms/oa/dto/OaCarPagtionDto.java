package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaCar;

import java.util.List;

public class OaCarPagtionDto {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private List<OaCar> carList;

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

    public List<OaCar> getCarList() {
        return carList;
    }

    public void setCarList(List<OaCar> carList) {
        this.carList = carList;
    }
}
