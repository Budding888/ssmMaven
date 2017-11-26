package com._520it.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(String username, HttpSession session, Model model) {

        if ("admin".equals(username)) {
            session.setAttribute("USER_IN_SESSION", "admin");
            return "redirect:/user/query.do";
        } else {
            model.addAttribute("登录失败");
            return "forward:/login.jsp";
        }


    }


}
