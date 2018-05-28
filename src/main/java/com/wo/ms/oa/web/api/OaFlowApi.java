package com.wo.ms.oa.web.api;

import com.wo.ms.oa.dto.OaFlowDto;
import com.wo.ms.oa.entity.*;
import com.wo.ms.oa.services.*;
import com.wo.ms.oa.util.WebUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private OaInfoService oaInfoService;

    @PostMapping("/add")
    public Map<String, Object> addFlow(@RequestBody OaFlowDto oaFlowDto){
        Map<String, Object> result = new HashMap<>();
        try{
            Integer loginId = webUtil.getLoginId();
            Date now = new Date();
            FlowCarMeeting flowCarMeeting = new FlowCarMeeting();
            OaFlow oaFlow = new OaFlow();

            //初始化流程相关数据
            oaFlow.setFlowName(oaFlowDto.getFlowName());
            oaFlow.setLaunchId(webUtil.getLoginId());
            oaFlow.setLaunchName(oaUserService.selectOaUser(webUtil.getLoginId()).getName());
            oaFlow.setCreateId(loginId);
            oaFlow.setUpdateId(loginId);
            oaFlow.setCreateTime(now);
            oaFlow.setUpdateTime(now);
            oaFlow.setId(oaFlowDto.getFlowId());
            oaFlow.setStatus(oaFlowDto.getStatus());

            if(oaFlowDto.getFlowId() == null){
                oaFlowService.insert(oaFlow);
            } else {
                oaFlowService.updateByPrimaryKeySelective(oaFlow);
            }

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

                flowCarMeeting.setUseCarRecordId(useCarRecord.getId());
                flowCarMeeting.setFlowId(oaFlow.getId());
                flowCarMeeting.setMeetingId(0);

                if( oaFlowDto.getFlowId() == null){
                    useCarRecordService.insert(useCarRecord);
                    flowCarMeeting.setUseCarRecordId(useCarRecord.getId());
                    oaFlowService.addFlowCarMeeting(flowCarMeeting);
                } else {
                    useCarRecord.setId(oaFlowDto.getUseCarRecordId());
                    flowCarMeeting.setUseCarRecordId(useCarRecord.getId());
                    useCarRecordService.updateByPrimaryKeySelective(useCarRecord);
                }
            } else{
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

                flowCarMeeting.setUseCarRecordId(0);
                flowCarMeeting.setFlowId(oaFlow.getId());
                flowCarMeeting.setMeetingId(oaMeeting.getId());

                if(oaFlowDto.getFlowId() == null){
                    oaMeetingService.insert(oaMeeting);
                    flowCarMeeting.setMeetingId(oaMeeting.getId());
                    oaFlowService.addFlowCarMeeting(flowCarMeeting);
                } else {
                    oaMeeting.setId(oaFlowDto.getMeetingId());
                    flowCarMeeting.setMeetingId(oaMeeting.getId());
                    oaMeetingService.updateByPrimaryKeySelective(oaMeeting);
                }
            }

            if(oaFlow.getStatus() == 2){
                oaFlow.setId(null);
                oaFlow.setStatus(3);
                oaFlowService.insert(oaFlow);
                //生成一条状态为部长审批的记录
                flowCarMeeting.setFlowId(oaFlow.getId());
                oaFlowService.addFlowCarMeeting(flowCarMeeting);
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
            OaUser user = oaUserService.selectOaUser(loginId);
            Date now = new Date();
            FlowCarMeeting flowCarMeeting = new FlowCarMeeting();
            boolean isZjlApproval = false; // 当前是否是总经理审批

            //更新上一个节点审批人数据
            OaFlow oaFlow = oaFlowService.selectFlow(oaFlowDto.getFlowId());
            oaFlow.setApprovalId(loginId);
            oaFlow.setApprovalName(user.getName());
            oaFlow.setUpdateId(loginId);
            oaFlow.setUpdateTime(now);
            oaFlow.setOpinion(oaFlowDto.getOpinion());
            oaFlowService.updateByPrimaryKeySelective(oaFlow);

            oaFlow.setId(null);
            oaFlow.setCreateTime(now);

            if(oaFlowDto.getOpinion() == 0) {
                // 同意之后，新建下一个节点数据
                if(oaFlow.getStatus() == 5){
                    // 如果当前是总经理审批，则结束流程
                    isZjlApproval = true;
                    oaFlow.setStatus(0);
                    OaInfo info = new OaInfo();
                    info.setStatus(1);
                    info.setDelFlg(0);
                    info.setContent("您的流程已经审批完成");
                    info.setInfoTitle("流程审批");
                    info.setCreateTime(now);
                    info.setCreateId(loginId);
                    info.setUpdateTime(now);
                    info.setUpdateId(loginId);
                    info.setImportant(1);
                    info.setPublishId(0);
                    info.setInfoType("系统通知");
                    List<Integer> userId = new ArrayList<>();
                    userId.add(oaFlow.getLaunchId());
                    result.put("sendInfo", true);
                    oaInfoService.publishInfo(info, userId);
                } else {
                    if("meeting".equals(oaFlowDto.getFlowType()) && oaFlow.getStatus() == 3){
                        oaFlow.setStatus(5);
                    } else {
                        oaFlow.setStatus(oaFlow.getStatus() + 1);
                    }
                }
            } else {
                // 驳回后，状态变成编辑状态
                oaFlow.setStatus(1);
            }

            if(isZjlApproval){

            } else {
                // 不是最后一个节点，并且不是同意
                oaFlow.setApprovalName(null);
                oaFlow.setApprovalId(null);
                oaFlow.setOpinion(null);
                Integer flowId = oaFlowService.insert(oaFlow);
                flowCarMeeting.setFlowId(oaFlow.getId());
                flowCarMeeting.setMeetingId(oaFlowDto.getMeetingId());
                flowCarMeeting.setUseCarRecordId(oaFlowDto.getUseCarRecordId());

                oaFlowService.addFlowCarMeeting(flowCarMeeting);
            }

            result.put("status", true);
            result.put("message", "操作成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "操作流程发生错误");
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
