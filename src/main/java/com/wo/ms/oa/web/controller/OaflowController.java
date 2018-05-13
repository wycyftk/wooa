package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaFlowPagtionDto;
import com.wo.ms.oa.entity.OaFlow;
import com.wo.ms.oa.entity.UseCarRecord;
import com.wo.ms.oa.services.OaFlowService;
import com.wo.ms.oa.services.UseCarRecordService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa/flow")
public class OaflowController {
    @Resource
    private WebUtil webUtil;

    @Resource
    private OaFlowService oaFlowService;

    @Resource
    private UseCarRecordService useCarRecordService;

    /**
     * 查询自己提交的流程
     * @param key 关键字
     * @param pageSize
     * @param currentPage
     * @return
     */
    @RequestMapping("/myWork")
    public ModelAndView myWork(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("wo/oa/flow/myWork");
        key = key == null ? "" : key;

        OaFlowPagtionDto oaFlowPagtion = oaFlowService.selectFlowByKeyLimit(key, pageSize, currentPage, webUtil.getLoginId());
        view.addObject("oaFlowPagtion", oaFlowPagtion);
        view.addObject("key", key);
        return view;
    }

    @RequestMapping("/newWork")
    public ModelAndView newWork(){
        ModelAndView view = new ModelAndView("wo/oa/flow/flowForm");
        return view;
    }

    @RequestMapping("/editWork")
    public ModelAndView editWork(@RequestParam("flowId") Integer flowId){
        ModelAndView view = new ModelAndView("wo/oa/flow/flowForm");
        return view;
    }

    @RequestMapping("/approval")
    public ModelAndView approval(@RequestParam("flowId") Integer flowId){
        ModelAndView view = new ModelAndView("wo/oa/flow/approvalFlowForm");
        OaFlow oaFlow = oaFlowService.selectFlow(flowId);
        UseCarRecord useCarRecord = useCarRecordService.selectUserCarRecordByFlowId(flowId);

        view.addObject("flow", oaFlow);
        view.addObject("car", useCarRecord);
        if(useCarRecord != null){
            view.addObject("flowType", "car");
        } else {
            view.addObject("flowType", "meeting");
        }
        return view;
    }
}
