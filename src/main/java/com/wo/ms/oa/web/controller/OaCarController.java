package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaCarPagtionDto;
import com.wo.ms.oa.entity.OaCar;
import com.wo.ms.oa.services.OaCarService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa/car")
public class OaCarController {
    @Resource
    private OaCarService oaCarService;

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("wo/oa/car/carList");
        key = key == null ? "" : key;

        OaCarPagtionDto oaCarPagtion = oaCarService.selectCarByKeyPation(key, pageSize, currentPage);
        view.addObject("oaCarPagtion", oaCarPagtion);
        view.addObject("key", key);
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("wo/oa/car/carForm");
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") Integer id){
        ModelAndView view = new ModelAndView("wo/oa/car/carForm");
        OaCar car = oaCarService.selectByPrimaryKey(id);
        view.addObject("car", car);
        return view;
    }
}
