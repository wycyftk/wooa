package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa")
public class Home {
    @Resource
    private WebUtil webUtil;

    @Resource
    private OaUserService oaUserService;

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "wo/oa/login";
    }

    @RequestMapping("/home")
    public ModelAndView homePage(){
        ModelAndView view = new ModelAndView("wo/oa/index");
        OaUser oaUser = oaUserService.selectOaUser(webUtil.getLoginId());
        view.addObject("user", oaUser);
        return view;
    }
}
