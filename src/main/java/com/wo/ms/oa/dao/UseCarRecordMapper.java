package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.UseCarRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UseCarRecordMapper {
    int insert(UseCarRecord record);

    int updateByPrimaryKeySelective(@Param("car") UseCarRecord record);

    int deleteUseCarRecord(@Param("id") Integer id);

    UseCarRecord selectUserCarRecordByFlowId(Integer flowId);

    UseCarRecord selectByPrimaryKey(Integer id);

    List<UseCarRecord> selectUseCarRecordByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("loginId") Integer loginId);

    Integer selectCountByKey(@Param("key") String key, @Param("loginId") Integer loginId);
}