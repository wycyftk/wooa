package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.dto.OaMenuPagtionDto;
import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.services.OaMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/oa/menu")
public class OaMenuController {
    @Resource
    private OaMenuService oaMenuService;

    @RequestMapping("/list")
    public ModelAndView menuList(@RequestParam(name = "key", required = false) String key, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("wo/oa/menu/menuList");
        OaMenuPagtionDto oaMenuPagtion = oaMenuService.selectMenuByKeyPaging(key, pageSize, currentPage);
        key = key != null ? "" : key;

        view.addObject("oaMenuPagtion", oaMenuPagtion);
        view.addObject("key" ,key);
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView updateMenu(Integer id){
        ModelAndView view = new ModelAndView("wo/oa/menu/menuForm");
        OaMenu oaMenu= oaMenuService.selectByPrimaryKey(id);
        view.addObject("menu", oaMenu);
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView addMenu(){
        ModelAndView view = new ModelAndView("wo/oa/menu/menuForm");
        List<OaMenu> firstLevelMenus = oaMenuService.selectMenusByLevel(1);
        view.addObject("menuList", firstLevelMenus);
        return view;
    }
}
