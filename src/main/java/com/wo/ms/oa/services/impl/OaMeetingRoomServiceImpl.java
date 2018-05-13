package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaMeetingMapper;
import com.wo.ms.oa.dao.OaMeetingRoomMapper;
import com.wo.ms.oa.entity.OaMeeting;
import com.wo.ms.oa.entity.OaMeetingRoom;
import com.wo.ms.oa.services.OaMeetingRoomService;
import com.wo.ms.oa.services.OaMeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaMeetingRoomServiceImpl implements OaMeetingRoomService{
    @Resource
    private OaMeetingRoomMapper oaMeetingRoomMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaMeetingRoomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaMeetingRoom record) {
        return oaMeetingRoomMapper.insert(record);
    }

    @Override
    public OaMeetingRoom selectByPrimaryKey(Integer id) {
        return oaMeetingRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OaMeetingRoom record) {
        return oaMeetingRoomMapper.updateByPrimaryKeySelective(record);
    }
}
