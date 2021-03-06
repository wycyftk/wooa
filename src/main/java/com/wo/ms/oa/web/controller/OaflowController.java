package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaFlowDto;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询自己提交的流程
     * @param key 关键字
     * @param pageSize
     * @param currentPage
     * @return
     */
    @RequestMapping("/todoWork")
    public ModelAndView todoWork(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage, HttpServletRequest request){
        ModelAndView view = new ModelAndView("wo/oa/flow/todoWorkList");
        key = key == null ? "" : key;
        HttpSession session = request.getSession();
        List<String> roleCodes = (List<String>)session.getAttribute("roleCodes");
        List<Integer> orgIds = (List<Integer>) session.getAttribute("orgIds");

        OaFlowPagtionDto oaFlowPagtion = oaFlowService.selectFlowByKeyLimitTodo(key, pageSize, currentPage, webUtil.getLoginId(), roleCodes, orgIds);
        view.addObject("oaFlowPagtion", oaFlowPagtion);
        view.addObject("key", key);
        return view;
    }

    /**
     * 查询自己处理过的流程
     * @param key 关键字
     * @param pageSize
     * @param currentPage
     * @return
     */
    @RequestMapping("/completeWork")
    public ModelAndView completeWork(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage, HttpServletRequest request){
        ModelAndView view = new ModelAndView("wo/oa/flow/completeWork");
        key = key == null ? "" : key;

        OaFlowPagtionDto oaFlowPagtion = oaFlowService.selectCompleteFlowByKeyLimit(key, pageSize, currentPage, webUtil.getLoginId());
        view.addObject("oaFlowPagtion", oaFlowPagtion);
        view.addObject("key", key);
        return view;
    }

    @RequestMapping("/newWork")
    public ModelAndView newWork(){
        ModelAndView view = new ModelAndView("wo/oa/flow/flowForm");
        Map<String, Object> oaFlowDto = new HashMap<>();
        view.addObject("flow", oaFlowDto);
        return view;
    }

    @RequestMapping("/editWork")
    public ModelAndView editWork(@RequestParam("flowId") Integer flowId){
        ModelAndView view = new ModelAndView("wo/oa/flow/flowForm");
        Map<String, Object> oaFlowDto = oaFlowService.selectFlowById(flowId);
        view.addObject("flow", oaFlowDto);
        return view;
    }

    @RequestMapping("/approval")
    public ModelAndView approval(@RequestParam("flowId") Integer flowId){
        ModelAndView view = new ModelAndView("wo/oa/flow/approvalFlowForm");
        Map<String, Object> oaFlow = oaFlowService.selectFlowById(flowId);

        view.addObject("flow", oaFlow);
        return view;
    }
}
