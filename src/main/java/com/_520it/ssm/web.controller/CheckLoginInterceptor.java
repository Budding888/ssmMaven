package com._520it.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        Object user = req.getSession().getAttribute("USER_IN_SESSION");
        if (user==null){
            resp.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }

}
