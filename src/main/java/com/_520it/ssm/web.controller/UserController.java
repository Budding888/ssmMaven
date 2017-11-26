package com._520it.ssm.web.controller;



import com._520it.ssm.domain.User;
import com._520it.ssm.query.PageResult;
import com._520it.ssm.query.UserQueryObject;
import com._520it.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;


    @RequestMapping("query")
    public String query(Model model, @ModelAttribute("qo")UserQueryObject qo  ) {
        PageResult pageResult = service.query(qo);
        model.addAttribute("pageResult",pageResult);  //在页面: 以"list" 中的值来取值
        return "user/list";
    }


    @RequestMapping("input")
    public String input(Model model, Long id) {
     if (id!=null){

        User user  = service.get(id);       //获得数据
        model.addAttribute("user",user); //将数据设置为属性, 便于后台获取, 回显数据 . 重要点!!!!!!!!!
     }
        return "user/input";
    }


    @RequestMapping("delete")
    public String delete(Model model, Long id) {
     if (id!=null){
        service.delete(id);
     }
        return "redirect:/user/query.do";
    }


    @RequestMapping("SaveOrUpdate")
    public String SaveOrUpdate(Model model, User user ) {
     if (user.getId()!=null){
        service.update(user);
     }
     else{
         service.save(user);
     }
        return "redirect:/user/query.do";
    }










}



