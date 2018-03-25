package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMeetingRoom;

public interface OaMeetingRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeetingRoom record);

    OaMeetingRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMeetingRoom record);
}