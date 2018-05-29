package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.UseCarRecordPagtion;
import com.wo.ms.oa.entity.UseCarRecord;
import com.wo.ms.oa.services.UseCarRecordService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa/useCar")
public class UseCarRecordController {
    @Resource
    private UseCarRecordService useCarRecordService;

    @Resource
    private WebUtil webUtil;

    @RequestMapping("/list")
    private ModelAndView list(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("/wo/oa/car/useCarList");
        key = key == null ? "" : key;

        UseCarRecordPagtion useCarRecordPagtion = useCarRecordService.selectMyUseCarLimit(key, pageSize, currentPage, webUtil.getLoginId());
        view.addObject("useCarRecordPagtion", useCarRecordPagtion);
        return view;
    }

    @RequestMapping("/view")
    private ModelAndView viewMeeting(@RequestParam("id") Integer id){
        ModelAndView view = new ModelAndView("/wo/oa/car/useCarContent");
        UseCarRecord useCarRecord = useCarRecordService.selectUseCarRecordByPrimary(id);
        view.addObject("useCarRecord", useCarRecord);
        return view;
    }
}
