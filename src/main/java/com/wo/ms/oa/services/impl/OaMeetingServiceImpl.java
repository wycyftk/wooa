package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaMeetingMapper;
import com.wo.ms.oa.entity.OaMeeting;
import com.wo.ms.oa.services.OaMeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaMeetingServiceImpl implements OaMeetingService {
    @Resource
    private OaMeetingMapper oaMeetingMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaMeetingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaMeeting record) {
        return oaMeetingMapper.insert(record);
    }

    @Override
    public OaMeeting selectByPrimaryKey(Integer id) {
        return oaMeetingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OaMeeting record) {
        return oaMeetingMapper.updateByPrimaryKeySelective(record);
    }
}
