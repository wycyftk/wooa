package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaFlowMapper;
import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.FlowCarMeeting;
import com.wo.ms.oa.entity.OaFlow;
import com.wo.ms.oa.services.OaFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public OaFlowPagtionDto selectFlowByKeyLimitTodo(String key, Integer pageSize, Integer currentPage, Integer loginId, List<String> roleList, List<Integer> orgIds) {
        OaFlowPagtionDto oaFlowPagtionDto = new OaFlowPagtionDto();
        List<OaFlow> flows = new ArrayList<>();
        List<OaFlow> newFlows = new ArrayList<>();

        oaFlowPagtionDto.setCurrentPage(currentPage);
        oaFlowPagtionDto.setPageSize(pageSize);

        if(roleList.contains("president")){
            flows.addAll(oaFlowMapper.selectFlowByKeyLimitByStatus(key, pageSize, (currentPage - 1) * pageSize, 4));
        } else if (roleList.contains("res_admin")){
            flows.addAll(oaFlowMapper.selectFlowByKeyLimitByStatus(key, pageSize, (currentPage - 1) * pageSize, 5));
        } else if (roleList.contains("minister")) {
            flows.addAll(oaFlowMapper.selectFlowByKeyLimitByOrgIds(key, pageSize, (currentPage - 1) * pageSize, orgIds, loginId));
        }

        int i = 0, index = i + (currentPage - 1) * pageSize;

        while (i < pageSize && i < flows.size()){
            if(flows.size() > index)
                newFlows.add(flows.get(index));
            i++;
            index++;
        }

        oaFlowPagtionDto.setFlowList(newFlows);
        oaFlowPagtionDto.setTotalPage((flows.size() - 1) / pageSize + 1 );
        return oaFlowPagtionDto;
    }

    @Override
    public OaFlow selectFlow(Integer id) {
        return oaFlowMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectFlowById(Integer flowId) {
        Map<String, Object> carFlow = oaFlowMapper.selectCarFlowById(flowId);
        Map<String, Object> meetingFlow = oaFlowMapper.selectMeetingFlowById(flowId);

        if (!carFlow.isEmpty()){
            carFlow.put("flowType", "car");
            return carFlow;
        } else {
            meetingFlow.put("flowType", "meeting");
            return meetingFlow;
        }
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

    @Override
    public int updateByPrimaryKeySelective(OaFlow oaFlow) {
        return oaFlowMapper.updateByPrimaryKeySelective(oaFlow);
    }
}
