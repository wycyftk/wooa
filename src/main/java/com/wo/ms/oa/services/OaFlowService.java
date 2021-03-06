package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaFlowDto;
import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.FlowCarMeeting;
import com.wo.ms.oa.entity.OaFlow;

import java.util.List;
import java.util.Map;

public interface OaFlowService {
    OaFlowPagtionDto selectFlowByKeyLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);

    OaFlowPagtionDto selectFlowByKeyLimitTodo(String key, Integer pageSize, Integer currentPage, Integer loginId, List<String> roleList, List<Integer> orgIds);

    OaFlowPagtionDto selectCompleteFlowByKeyLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);

    OaFlow selectFlow(Integer id);

    Map<String, Object> selectFlowById(Integer flowId);

    int insert(OaFlow oaFlow);

    int deleteFlow(Integer id, String type);

    int addFlowCarMeeting(FlowCarMeeting flowCarMeeting);

    int updateByPrimaryKeySelective(OaFlow oaFlow);
}
