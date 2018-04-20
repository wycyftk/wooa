package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/oa/user")
public class OaUserController {
    @Resource
    private OaUserService oaUserService;

    /**
     * 用户列表页面
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView oaUserPage(){
        ModelAndView view = new ModelAndView("wo/oa/user/userList");
        List<OaUser> oaUsers = oaUserService.selectOaUserByKey(null);
        view.addObject("userList", oaUsers);
        return view;
    }

    /**
     * 新增用户页面
     * @return
     */
    @RequestMapping("/addUser")
    public String addUserPage(){
        return "wo/oa/user/userForm";
    }

    /**
     * 编辑用户
     * @param id
     * @return
     */
    @RequestMapping("/editUser")
    public ModelAndView editUserPage(Integer id){
        OaUser oaUser = oaUserService.selectOaUser(id);
        ModelAndView view = new ModelAndView("wo/oa/user/userForm");
        view.addObject("user", oaUser);
        return view;
    }
}
