package com.example.text.Controller;

import com.example.text.dao.userdao;
import com.example.text.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class changecontroller {
    @Autowired
    userdao use;

    @PostMapping("/cp")
    public String cp(@RequestParam("username")String name, @RequestParam("usepassword")String up, @RequestParam("newpassword")String np, Model model){
        user a=new user(name,up);
        if (use.login(a)==a){
            use.jia(new user(name,np));
            return "login";
        }
        else {
            model.addAttribute("msg","原用户名或密码错误");
            return "change";
        }
    }
}
