package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.FlowCarMeeting;
import com.wo.ms.oa.entity.OaFlow;

import java.util.List;

public interface OaFlowService {
    OaFlowPagtionDto selectFlowByKeyLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);

    OaFlowPagtionDto selectFlowByKeyLimitTodo(String key, Integer pageSize, Integer currentPage, Integer loginId, List<String> roleList, List<Integer> orgIds);

    OaFlow selectFlow(Integer id);

    int insert(OaFlow oaFlow);

    int deleteFlow(Integer id, String type);

    int addFlowCarMeeting(FlowCarMeeting flowCarMeeting);

    int updateByPrimaryKeySelective(OaFlow oaFlow);
}
