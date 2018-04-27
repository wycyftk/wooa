package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/login")
public class LoginApi {
    @Resource
    private OaUserService oaUserService;

    @PostMapping("/in")
    public Map<String, Object> login(@RequestBody OaUser oaUser, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        Integer userId = oaUserService.checkUser(oaUser.getUsername(), oaUser.getPassword());
        if(userId > 0){
            request.getSession().setAttribute("loginId", userId);
            result.put("status", true);
            result.put("message", "登录成功");
        }else {
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
