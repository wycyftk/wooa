package com.wo.ms.oa.web.controller;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/oa")
public class Home {
    @Resource
    private WebUtil webUtil;

    @Resource
    private OaUserService oaUserService;

    @Resource
    private OaInfoService oaInfoService;

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "wo/oa/login";
    }

    @RequestMapping("/home")
    public ModelAndView homePage(HttpServletRequest request){
        ModelAndView view = new ModelAndView("wo/oa/index");
        OaUser oaUser = oaUserService.selectOaUser(webUtil.getLoginId());
        HttpSession session = request.getSession();
        List<String> roleList = (List<String>)session.getAttribute("roleCodes");
        List<Integer> orgIds = (List<Integer>) session.getAttribute("orgIds");
        Integer noReadInfo = oaInfoService.selectNoReadInfoNum(webUtil.getLoginId());
        view.addObject("user", oaUser);
        view.addObject("roleList", roleList);
        view.addObject("noReadInfo", noReadInfo);
        return view;
    }

    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView view = new ModelAndView("wo/oa/layout/main");
        return view;
    }
}
