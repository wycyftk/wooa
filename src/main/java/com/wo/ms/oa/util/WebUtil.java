package com.wo.ms.oa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtil {
    @Autowired
    private HttpServletRequest request;

    public Integer getLoginId(){
        if(request.getSession().getAttribute("loginId") != null){
            return Integer.parseInt(request.getSession().getAttribute("loginId").toString());
        }else {
            return null;
        }
    }
}
