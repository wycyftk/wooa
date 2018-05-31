package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMeeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OaMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeeting record);

    OaMeeting selectByPrimaryKey(Integer id);

    List<OaMeeting> selectMyMeeting(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("loginId") Integer loginId);

    Integer selectCountMyMeeting(@Param("key") String key, @Param("loginId") Integer loginId);

    int updateByPrimaryKeySelective(OaMeeting record);

    List<Map<Integer, Integer>> selectDayAndMeetingNum();
}