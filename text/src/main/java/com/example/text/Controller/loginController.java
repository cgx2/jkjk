package com.example.text.Controller;

import com.example.text.dao.userdao;
import com.example.text.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class loginController {
    @Autowired
    userdao use;
    @RequestMapping("/user/login")
    public String login(@RequestParam("userName")String username, @RequestParam("password")String password, Model model, HttpSession session){
//        if (username.equals("cgx")&&password.equals("123456")) {
//            session.setAttribute("cgx",username);
//            return "redirect:/home.html";
//        }
        user a=new user(username,password);
        if (use.login(a)==a){
            session.setAttribute("cgx",username);
            return "redirect:/home.html";
        }
        else {
            System.out.println(use.login(a));
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
    @GetMapping("/user")
    public String user(){
        return "book";
    }
    @GetMapping("map")
    public String map(){
        return "baidumap";
    }
}
