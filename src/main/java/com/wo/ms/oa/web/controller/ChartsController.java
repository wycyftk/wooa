package com.wo.ms.oa.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oa/charts")
public class ChartsController {
    @RequestMapping("/charts")
    public String charts(){
        return "wo/oa/charts/charts";
    }
}
