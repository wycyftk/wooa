package com.wo.ms.oa.web.api;

import com.wo.ms.oa.dto.OaFlowDto;
import com.wo.ms.oa.entity.*;
import com.wo.ms.oa.services.OaFlowService;
import com.wo.ms.oa.services.OaMeetingService;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.services.UseCarRecordService;
import com.wo.ms.oa.util.WebUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

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
    private OaMeetingService oaMeetingService;

    @Resource
    private OaFlowService oaFlowService;

    @PostMapping("/add")
    public Map<String, Object> addFlow(@RequestBody OaFlowDto oaFlowDto){
        Map<String, Object> result = new HashMap<>();
        try{
            Integer loginId = webUtil.getLoginId();
            Date now = new Date();
            FlowCarMeeting flowCarMeeting = new FlowCarMeeting();

            //初始化流程相关数据
            OaFlow oaFlow = new OaFlow();
            oaFlow.setFlowName(oaFlowDto.getFlowName());
            oaFlow.setLaunchId(webUtil.getLoginId());
            oaFlow.setLaunchName(oaUserService.selectOaUser(webUtil.getLoginId()).getName());
            oaFlow.setCreateId(loginId);
            oaFlow.setUpdateId(loginId);
            oaFlow.setCreateTime(now);
            oaFlow.setUpdateTime(now);
            oaFlow.setStatus(oaFlowDto.getStatus());
            Integer flowId = oaFlowService.insert(oaFlow);

            if("car".equals(oaFlowDto.getFlowType())){
                UseCarRecord useCarRecord = new UseCarRecord();
                useCarRecord.setCarId(oaFlowDto.getCarId());
                useCarRecord.setCarName(oaFlowDto.getCarName());
                useCarRecord.setEndTime(oaFlowDto.getEndTime());
                useCarRecord.setStartTime(oaFlowDto.getStartTime());
                useCarRecord.setReason(oaFlowDto.getReason());
                useCarRecord.setCreateId(loginId);
                useCarRecord.setCreateTime(now);
                useCarRecord.setUpdateId(loginId);
                useCarRecord.setUpdateTime(now);
                useCarRecord.setCarStatus(1);  //用车申请审批中
                useCarRecordService.insert(useCarRecord);

                flowCarMeeting.setUseCarRecordId(useCarRecord.getId());
                flowCarMeeting.setFlowId(oaFlow.getId());
                flowCarMeeting.setMeetingId(0);
            } else {
                OaMeeting oaMeeting = new OaMeeting();
                oaMeeting.setStartTime(oaFlowDto.getStartTime());
                oaMeeting.setEndTime(oaFlowDto.getEndTime());
                oaMeeting.setMeetingName(oaFlowDto.getMeetingName());
                oaMeeting.setMeetingRoom(oaFlowDto.getMeetingRoom());
                oaMeeting.setOaMeetingRoomId(oaFlowDto.getMeetingRoomId());
                oaMeeting.setCreateId(loginId);
                oaMeeting.setCreateTime(now);
                oaMeeting.setUpdateId(loginId);
                oaMeeting.setUpdateTime(now);
                oaMeeting.setStatus(2);  //会议申请审批中
                oaMeetingService.insert(oaMeeting);

                flowCarMeeting.setUseCarRecordId(0);
                flowCarMeeting.setFlowId(oaFlow.getId());
                flowCarMeeting.setMeetingId(oaMeeting.getId());
            }

            oaFlowService.addFlowCarMeeting(flowCarMeeting);
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
                useCarRecord.setReason(oaFlowDto.getReason());
                useCarRecord.setUpdateId(loginId);
                useCarRecord.setCarStatus(2);
                useCarRecordService.updateByPrimaryKeySelective(useCarRecord);
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

    @DeleteMapping("/delFlow")
    public Map<String, Object> deleteFlow(@RequestParam("id") Integer id, @RequestParam("type") String type){
        Map<String, Object> result = new HashMap<>();
        try{
            oaFlowService.deleteFlow(id, type);

            if("car".equals(type)){
                useCarRecordService.deleteUseCarRecord(id);
            } else {
                oaMeetingService.deleteByPrimaryKey(id);
            }
            result.put("status", true);
            result.put("message", "删除流程成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "删除流程失败");
        }
        return result;
    }
}
