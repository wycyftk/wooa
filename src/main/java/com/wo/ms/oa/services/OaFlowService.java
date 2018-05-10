package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.OaFlow;

public interface OaFlowService {
    OaFlowPagtionDto selectFlowByKeyLimit(String key, Integer pageSize, Integer currentPage, Integer loginId);

    OaFlow selectFlow(Integer id);

    int insert(OaFlow oaFlow);
}
