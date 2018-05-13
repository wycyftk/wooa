package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaOrgService;
import com.wo.ms.oa.services.OaRoleService;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/login")
public class LoginApi {
    @Resource
    private OaUserService oaUserService;

    @Resource
    private OaRoleService oaRoleService;

    @Resource
    private OaOrgService oaOrgService;

    @PostMapping("/in")
    public Map<String, Object> login(@RequestBody OaUser oaUser, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        try{
            //将用户的id、 角色、 组织id存在session里
            Integer userId = oaUserService.checkUser(oaUser.getUsername(), oaUser.getPassword());
            List<String> roleCodes = oaRoleService.selectUserRoleCode(userId);
            List<Integer> orgIds = oaOrgService.selectUserOrgId(userId);
            request.getSession().setAttribute("loginId", userId);
            request.getSession().setAttribute("roleCodes", roleCodes);
            request.getSession().setAttribute("orgIds", orgIds);
            result.put("status", true);
            result.put("message", "登录成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "帐号或密码错误");
        }
        return result;
    }

    @GetMapping("/out")
    public Map<String, Object> logout(HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginId") != null){
            session.removeAttribute("loginId");
            result.put("status", true);
            result.put("message", "退出系统成功");
        }else {
            result.put("status", false);
            result.put("message", "尚未登录");
        }
        return result;
    }
}
