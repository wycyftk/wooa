package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaMeetingPagtion;
import com.wo.ms.oa.entity.OaMeeting;

public interface OaMeetingService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMeeting record);

    OaMeeting selectByPrimaryKey(Integer id);

    OaMeetingPagtion selectMyMeetingLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);

    int updateByPrimaryKeySelective(OaMeeting record);
}
