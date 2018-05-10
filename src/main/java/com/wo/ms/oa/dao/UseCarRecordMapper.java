package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.UseCarRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UseCarRecordMapper {
    int insert(UseCarRecord record);

    int updateByPrimaryKeySelective(@Param("car") UseCarRecord record, @Param("flowId") Integer flowId);

    UseCarRecord selectUserCarRecordByFlowId(Integer flowId);
}