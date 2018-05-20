package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaMeetingRoom;

import java.util.List;

public class OaMeetingRoomPagtion {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private List<OaMeetingRoom> meetingRoomList;

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

    public List<OaMeetingRoom> getMeetingRoomList() {
        return meetingRoomList;
    }

    public void setMeetingRoomList(List<OaMeetingRoom> meetingRoomList) {
        this.meetingRoomList = meetingRoomList;
    }
}
