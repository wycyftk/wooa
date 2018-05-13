package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaFlowMapper;
import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.FlowCarMeeting;
import com.wo.ms.oa.entity.OaFlow;
import com.wo.ms.oa.services.OaFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaFlowServiceImpl implements OaFlowService {
    @Resource
    private OaFlowMapper oaFlowMapper;

    @Override
    public OaFlowPagtionDto selectFlowByKeyLimit(String key, Integer pageSize, Integer currentPage, Integer loginId) {
        OaFlowPagtionDto oaFlowPagtionDto = new OaFlowPagtionDto();
        oaFlowPagtionDto.setCurrentPage(currentPage);
        oaFlowPagtionDto.setPageSize(pageSize);
        oaFlowPagtionDto.setFlowInfo(oaFlowMapper.selectFlowByKeyLimit(key, pageSize, (currentPage - 1) * pageSize, loginId));
        oaFlowPagtionDto.setTotalPage((oaFlowMapper.selectFlowByKey(key, loginId) - 1) / pageSize + 1 );
        return oaFlowPagtionDto;
    }

    @Override
    public OaFlow selectFlow(Integer id) {
        return oaFlowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(OaFlow oaFlow) {
        return oaFlowMapper.insert(oaFlow);
    }

    @Override
    public int deleteFlow(Integer id, String type) {
        return oaFlowMapper.deleteFlow(id, type);
    }

    @Override
    public int addFlowCarMeeting(FlowCarMeeting flowCarMeeting) {
        return oaFlowMapper.addFlowCarMeeting(flowCarMeeting);
    }
}
