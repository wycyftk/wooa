package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaMeetingRoomPagtion;
import com.wo.ms.oa.entity.OaMeetingRoom;

import java.util.List;

public interface OaMeetingRoomService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeetingRoom record);

    OaMeetingRoom selectByPrimaryKey(Integer id);

    List<OaMeetingRoom> selectCanUseMeetingRoom();

    OaMeetingRoomPagtion selectMeetingRoomByKeyLimit(String key, Integer pageSize, Integer currentPage);

    int updateByPrimaryKeySelective(OaMeetingRoom record);
}
