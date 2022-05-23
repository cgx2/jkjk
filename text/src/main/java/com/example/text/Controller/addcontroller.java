package com.example.text.Controller;

import com.example.text.dao.ptdao;
import com.example.text.dao.studentdao;
import com.example.text.pojo.pt;
import com.example.text.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class addcontroller {
    @Autowired
    ptdao pp;
    @Autowired
    studentdao std;

    @PostMapping("/add")
    public String add(Integer id,@RequestParam("username")String username,@RequestParam("classname")String classname,@RequestParam("sex")int sex,@RequestParam("age")int age,@RequestParam("place")String place,@RequestParam("time")String time){
        pp.zz(new pt(id,place,time,username));
        std.zen(new student(id,username,classname,age,sex));
        return "redirect:/message";
    }

    @GetMapping("/xiugai/{ID}")
    public String xiu(@PathVariable("ID")Integer id,Model model){
        pt p=pp.getfromid(id);
        model.addAttribute("msg",p);
        student st=std.get(id);
        model.addAttribute("mst",st);
        return "xiu";
    }
    @PostMapping("/update")
    public String update(Integer id,@RequestParam("username")String username,@RequestParam("classname")String classname,@RequestParam("sex")int sex,@RequestParam("age")int age,@RequestParam("place")String place,@RequestParam("time")String time){
        pp.zz(new pt(id,place,time,username));
        std.zen(new student(id,username,classname,age,sex));
        return "redirect:/message";
    }
    @GetMapping("/delete/{ID}")
    public String delete(@PathVariable("ID")Integer id){
        pp.delete(id);
        std.delete(id);
        return "redirect:/message";
    }
}
