package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.services.OaRoleService;
import com.wo.ms.oa.dto.OaRolePagtionDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oa/role")
public class OaRoleController {
    @Resource
    private OaRoleService oaRoleService;

    @RequestMapping("/list")
    public ModelAndView roleListPage(@RequestParam(name = "key", required = false) String key,@RequestParam("pageSize") Integer pageSize,@RequestParam("currentPage") Integer currentPage){
        ModelAndView view = new ModelAndView("wo/oa/role/roleList");
        OaRolePagtionDto oaRoleVo = oaRoleService.selectByKeyPaging(key, pageSize, currentPage);
        view.addObject("rolePaging", oaRoleVo);
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView updateRole(Integer id){
        ModelAndView view = new ModelAndView("wo/oa/role/roleForm");
        OaRole oaRole = oaRoleService.selectByPrimaryKey(id);
        view.addObject("role", oaRole);
        return view;
    }

    @RequestMapping("/add")
    public String addRole(){
        return "wo/oa/role/roleForm";
    }
}
