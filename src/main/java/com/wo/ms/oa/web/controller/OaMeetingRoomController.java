package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaMeetingRoomPagtion;
import com.wo.ms.oa.entity.OaMeetingRoom;
import com.wo.ms.oa.services.OaMeetingRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa/meetingRoom")
public class OaMeetingRoomController {
    @Resource
    private OaMeetingRoomService oaMeetingRoomService;

    @RequestMapping("/list")
    private ModelAndView list(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("/wo/oa/meeting/meetingRoomList");
        key = key == null ? "" : key;
        OaMeetingRoomPagtion oaMeetingRoomPagtion = oaMeetingRoomService.selectMeetingRoomByKeyLimit(key, pageSize, currentPage);
        view.addObject("meetingRoomPagtion", oaMeetingRoomPagtion);
        return view;
    }

    @RequestMapping("/add")
    private ModelAndView add(){
        ModelAndView view = new ModelAndView("/wo/oa/meeting/meetingRoomForm");
        return view;
    }

    @RequestMapping("/update")
    private ModelAndView update(@RequestParam("id") Integer id){
        ModelAndView view = new ModelAndView("/wo/oa/meeting/meetingRoomForm");
        OaMeetingRoom oaMeetingRoom = oaMeetingRoomService.selectByPrimaryKey(id);
        view.addObject("meetingRoom", oaMeetingRoom);
        return view;
    }
}
