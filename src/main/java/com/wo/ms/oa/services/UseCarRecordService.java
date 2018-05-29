package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.UseCarRecordPagtion;
import com.wo.ms.oa.entity.UseCarRecord;

public interface UseCarRecordService {
    int insert(UseCarRecord record);

    int updateByPrimaryKeySelective(UseCarRecord record);

    int deleteUseCarRecord(Integer id);

    UseCarRecord selectUserCarRecordByFlowId(Integer flowId);

    UseCarRecord selectUseCarRecordByPrimary(Integer id);

    UseCarRecordPagtion selectMyUseCarLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);
}
