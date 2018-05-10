package com.wo.ms.oa.web.api;

import com.wo.ms.oa.dto.OaFlowDto;
import com.wo.ms.oa.entity.OaFlow;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.entity.UseCarRecord;
import com.wo.ms.oa.services.OaFlowService;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.services.UseCarRecordService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/flow")
public class OaFlowApi {
    @Resource
    private WebUtil webUtil;

    @Resource
    private OaUserService oaUserService;

    @Resource
    private UseCarRecordService useCarRecordService;

    @Resource
    private OaFlowService oaFlowService;

    @PostMapping("/add")
    public Map<String, Object> addFlow(@RequestBody OaFlowDto oaFlowDto){
        Map<String, Object> result = new HashMap<>();
        try{
            Integer loginId = webUtil.getLoginId();
            Date now = new Date();

            //初始化流程相关数据
            OaFlow oaFlow = new OaFlow();
            oaFlow.setFlowName(oaFlowDto.getFlowName());
            oaFlow.setLaunchId(webUtil.getLoginId());
            oaFlow.setLaunchName(oaUserService.selectOaUser(webUtil.getLoginId()).getName());
            oaFlow.setCreateId(loginId);
            oaFlow.setUpdateId(loginId);
            oaFlow.setCreateTime(now);
            oaFlow.setUpdateTime(now);
            Integer flowId = oaFlowService.insert(oaFlow);

            if("car".equals(oaFlowDto.getFlowType())){
                UseCarRecord useCarRecord = new UseCarRecord();
                useCarRecord.setCarId(oaFlowDto.getCarId());
                useCarRecord.setEndTime(oaFlowDto.getEndTime());
                useCarRecord.setStartTime(oaFlowDto.getStartTime());
                useCarRecord.setFlowId(oaFlow.getId());
                useCarRecord.setReason(oaFlowDto.getReason());
                useCarRecord.setFlowStatus(1);
                useCarRecordService.insert(useCarRecord);
            }

            result.put("status", true);
            result.put("message", "提交成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "提交流程发生错误");
        }
        return result;
    }

    @PostMapping("/approval")
    public Map<String, Object> approval(@RequestBody OaFlowDto oaFlowDto){
        Map<String, Object> result = new HashMap<>();

        try{
            Integer loginId = webUtil.getLoginId();
            Date now = new Date();

            //初始化流程相关数据
            OaFlow oaFlow = new OaFlow();
            oaFlow.setFlowName(oaFlowDto.getFlowName());
            oaFlow.setLaunchId(webUtil.getLoginId());
            oaFlow.setLaunchName(oaUserService.selectOaUser(webUtil.getLoginId()).getName());
            oaFlow.setCreateId(loginId);
            oaFlow.setUpdateId(loginId);
            oaFlow.setCreateTime(now);
            oaFlow.setUpdateTime(now);
            oaFlow.setApprovalId(loginId);
            Integer flowId = oaFlowService.insert(oaFlow);

            if("car".equals(oaFlowDto.getFlowType())){
                UseCarRecord useCarRecord = new UseCarRecord();
                useCarRecord.setCarId(oaFlowDto.getCarId());
                useCarRecord.setEndTime(oaFlowDto.getEndTime());
                useCarRecord.setStartTime(oaFlowDto.getStartTime());
                useCarRecord.setFlowId(oaFlow.getId());
                useCarRecord.setReason(oaFlowDto.getReason());
                useCarRecord.setFlowStatus(1);
                useCarRecordService.updateByPrimaryKeySelective(useCarRecord, oaFlowDto.getFlowId());
            }

            result.put("status", true);
            result.put("message", "提交成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "提交流程发生错误");
        }
        return result;
    }
}
