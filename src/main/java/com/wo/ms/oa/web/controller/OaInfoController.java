package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaInfoPagtionDto;
import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.services.OaMenuService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/oa/info")
public class OaInfoController {
    @Resource
    private OaInfoService oaInfoService;

    @Resource
    private WebUtil webUtil;

    @RequestMapping("/list")
    public ModelAndView infoList(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("wo/oa/info/infoList");
        OaInfoPagtionDto infoPagtion = oaInfoService.selectInfoPagtionByKey(key, pageSize, currentPage);
        key = key == null ? "" : key;
        view.addObject("infoPagtion", infoPagtion);
        view.addObject("key", key);
        view.addObject("loginId", webUtil.getLoginId());
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

    @RequestMapping("/view")
    public ModelAndView infoPage(Integer id){
        ModelAndView view = new ModelAndView("wo/oa/info/infoContent");
        OaInfo info = oaInfoService.selectByPrimaryKey(id);
        view.addObject("info", info);
        return view;
    }
}
