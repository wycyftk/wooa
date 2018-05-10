package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.UseCarRecordMapper;
import com.wo.ms.oa.entity.UseCarRecord;
import com.wo.ms.oa.services.UseCarRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UseCarRecordServiceImpl implements UseCarRecordService {
    @Resource
    private UseCarRecordMapper useCarRecordMapper;

    @Override
    public int insert(UseCarRecord record) {
        return useCarRecordMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UseCarRecord record, Integer flowId) {
        return useCarRecordMapper.updateByPrimaryKeySelective(record, flowId);
    }

    @Override
    public UseCarRecord selectUserCarRecordByFlowId(Integer flowId) {
        return useCarRecordMapper.selectUserCarRecordByFlowId(flowId);
    }
}
