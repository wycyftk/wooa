package com.wo.ms.oa.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
        HttpSession session = request.getSession();
        //判断用户ID是否存在，不存在就跳转到登录界面
        if(session.getAttribute("loginId") == null){
            response.sendRedirect(request.getContextPath() + "/oa/loginPage");
            return false;
        }else{
            session.setAttribute("loginId", session.getAttribute("loginId"));
            if(request.getRequestURL().indexOf("/oa/loginPage") > 0){
                response.sendRedirect(request.getContextPath() + "/oa/home");
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }

}
