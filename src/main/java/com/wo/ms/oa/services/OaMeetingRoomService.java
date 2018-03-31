package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaMeetingRoom;

public interface OaMeetingRoomService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeetingRoom record);

    OaMeetingRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMeetingRoom record);
}
