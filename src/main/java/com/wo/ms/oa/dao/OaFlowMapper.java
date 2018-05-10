package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaFlow record);

    OaFlow selectByPrimaryKey(Integer id);

    List<OaFlow> selectFlowByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("loginId") Integer loginId);

    Integer selectFlowByKey(@Param("key") String key);
}