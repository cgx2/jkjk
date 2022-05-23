package com.example.text.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object a=request.getSession().getAttribute("cgx");
        if (a==null){
            request.setAttribute("msg","没有权限进入");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        else {
            return true;
        }
    }
}
