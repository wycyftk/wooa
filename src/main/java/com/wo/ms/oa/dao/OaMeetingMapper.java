package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMeeting;

public interface OaMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeeting record);

    OaMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMeeting record);
}