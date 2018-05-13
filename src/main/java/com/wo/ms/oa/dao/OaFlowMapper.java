package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.FlowCarMeeting;
import com.wo.ms.oa.entity.OaFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OaFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaFlow record);

    OaFlow selectByPrimaryKey(Integer id);

    List<Map<String, Object>> selectFlowByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("loginId") Integer loginId);

    Integer selectFlowByKey(@Param("key") String key, @Param("loginId") Integer loginId);

    int deleteFlow(@Param("id") Integer id, @Param("type") String type);

    int addFlowCarMeeting(FlowCarMeeting flowCarMeeting);
}