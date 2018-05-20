package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMeetingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaMeetingRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeetingRoom record);

    OaMeetingRoom selectByPrimaryKey(Integer id);

    List<OaMeetingRoom> selectByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start);

    List<OaMeetingRoom> selectCanUseMeetingRoom();

    Integer selectCountByKey(@Param("key") String key);

    int updateByPrimaryKeySelective(OaMeetingRoom record);
}