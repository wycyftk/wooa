package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.UseCarRecord;

public interface UseCarRecordService {
    int insert(UseCarRecord record);

    int updateByPrimaryKeySelective(UseCarRecord record);

    int deleteUseCarRecord(Integer id);

    UseCarRecord selectUserCarRecordByFlowId(Integer flowId);
}
