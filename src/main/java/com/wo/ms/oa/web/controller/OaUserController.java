package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa")
public class OaUserController {
    @Resource
    private OaUserService oaUserService;

    @RequestMapping("/user")
    public String oaUserPage(){
        OaUser oaUser = oaUserService.selectOaUser(1);
        System.out.print(oaUser.getName());
        return "wo/oa/index";
    }
}
