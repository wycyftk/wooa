package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.services.OaOrgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/oa/org")
@Controller
public class OaOrgController {
    @Resource
    private OaOrgService oaOrgService;

    @RequestMapping("/list")
    public ModelAndView orgList(){
        ModelAndView view = new ModelAndView("wo/oa/org/orgList");
        List<OaOrg> orgs = oaOrgService.selectAllOrg();
        view.addObject("orgList", orgs);
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView updateOrg(Integer id){
        ModelAndView view = new ModelAndView("wo/oa/org/orgForm");
        OaOrg oaOrg = oaOrgService.selectByPrimaryKey(id);
        view.addObject("org", oaOrg);
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView addOrg(){
        ModelAndView view = new ModelAndView("wo/oa/org/orgForm");
        List<OaOrg> firstLevelOrgs = oaOrgService.selectOrgsByLevel(1);
        view.addObject("orgList", firstLevelOrgs);
        return view;
    }
}
