package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.UseCarRecordMapper;
import com.wo.ms.oa.dto.UseCarRecordPagtion;
import com.wo.ms.oa.entity.UseCarRecord;
import com.wo.ms.oa.services.UseCarRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UseCarRecordServiceImpl implements UseCarRecordService {
    @Resource
    private UseCarRecordMapper useCarRecordMapper;

    @Override
    public int insert(UseCarRecord record) {
        return useCarRecordMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UseCarRecord record) {
        return useCarRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteUseCarRecord(Integer id) {
        return useCarRecordMapper.deleteUseCarRecord(id);
    }

    @Override
    public UseCarRecord selectUserCarRecordByFlowId(Integer flowId) {
        return useCarRecordMapper.selectUserCarRecordByFlowId(flowId);
    }

    @Override
    public UseCarRecord selectUseCarRecordByPrimary(Integer id) {
        return useCarRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map<Integer, Integer>> selectUseCarDayAndNum() {
        return useCarRecordMapper.selectUseCarDayAndNum();
    }

    @Override
    public UseCarRecordPagtion selectMyUseCarLimit(String key, Integer pageSize, Integer currentPage, Integer loginId) {
        UseCarRecordPagtion useCarRecordPagtion = new UseCarRecordPagtion();
        useCarRecordPagtion.setCurrentPage(currentPage);
        useCarRecordPagtion.setPageSize(pageSize);
        useCarRecordPagtion.setUseCarRecordList(useCarRecordMapper.selectUseCarRecordByKeyLimit(key, pageSize, (currentPage - 1) * pageSize, loginId));
        useCarRecordPagtion.setTotalPage(useCarRecordMapper.selectCountByKey(key, loginId));
        return useCarRecordPagtion;
    }
}
