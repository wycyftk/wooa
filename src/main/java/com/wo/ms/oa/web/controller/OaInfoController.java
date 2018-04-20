package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.services.OaMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/oa/info")
public class OaInfoController {
    @Resource
    private OaInfoService oaInfoService;

    @RequestMapping("/list")
    public ModelAndView infoList(){
        ModelAndView view = new ModelAndView("wo/oa/info/infoList");
        List<OaInfo> infoList = oaInfoService.selectAllInfos();
        view.addObject("infoList", infoList);
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView updateInfo(Integer id){
        ModelAndView view = new ModelAndView("wo/oa/info/infoForm");
        OaInfo oaInfo= oaInfoService.selectByPrimaryKey(id);
        view.addObject("info", oaInfo);
        return view;
    }

    @RequestMapping("/add")
    public String addMenu(){
        return "wo/oa/info/infoForm";
    }
}
