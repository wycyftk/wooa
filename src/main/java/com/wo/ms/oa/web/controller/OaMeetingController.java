package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaMeetingPagtion;
import com.wo.ms.oa.entity.OaMeeting;
import com.wo.ms.oa.services.OaMeetingService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/oa/meeting")
public class OaMeetingController {
    @Resource
    private OaMeetingService oaMeetingService;

    @Resource
    private WebUtil webUtil;

    @RequestMapping("/list")
    private ModelAndView list(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("/wo/oa/meeting/meetingList");
        key = key == null ? "" : key;

        OaMeetingPagtion oaMeetingPagtion = oaMeetingService.selectMyMeetingLimit(key, pageSize, currentPage, webUtil.getLoginId());
        view.addObject("oaMeetingPagtion", oaMeetingPagtion);
        return view;
    }

    @RequestMapping("/view")
    private ModelAndView viewMeeting(@RequestParam("id") Integer id){
        ModelAndView view = new ModelAndView("/wo/oa/meeting/meetingContent");
        OaMeeting oaMeeting = oaMeetingService.selectByPrimaryKey(id);
        view.addObject("oaMeeting", oaMeeting);
        return view;
    }
}
