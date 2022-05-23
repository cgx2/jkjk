package com.example.text.Controller;

import com.example.text.dao.ptdao;
import com.example.text.pojo.pt;
import com.example.text.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class ptcontroller {
    @Autowired
    ptdao pp;

    @RequestMapping("/message")
    public String msg(Model model){
        Collection<pt> pts=pp.getall();
        Collection<student>pt=pp.getstudent();
        model.addAttribute("ms",pts);
        model.addAttribute("mst",pt);
        return "xueshen";
    }
    @GetMapping("/go")
    public String jia(){
        return "add";
    }
    @GetMapping("/change")
    public String change(){
        return "change";
    }
}
