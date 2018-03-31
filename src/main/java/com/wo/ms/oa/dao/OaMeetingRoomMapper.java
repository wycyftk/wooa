package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMeetingRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaMeetingRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeetingRoom record);

    OaMeetingRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMeetingRoom record);
}