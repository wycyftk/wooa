package com.wo.ms.oa.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oa")
public class Home {
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "wo/oa/login";
    }

    @RequestMapping("/home")
    public String homePage(){
        return "wo/oa/index";
    }
}
