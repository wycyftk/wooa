package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaMeeting;

public interface OaMeetingService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeeting record);

    OaMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMeeting record);
}
