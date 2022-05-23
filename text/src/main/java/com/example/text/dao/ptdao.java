package com.example.text.dao;

import com.example.text.pojo.pt;
import com.example.text.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ptdao {
    public static Map<Integer, pt>pp=null;
    static {
        pp=new HashMap<Integer,pt>();
        pp.put(001,new pt(001,"图书馆","2000-10-29 16:40","陈冠希"));
        pp.put(002,new pt(002,"花园","2010-10-30 8:30","吴彦祖"));
        pp.put(003,new pt(003,"喷水池","2020-2-3 9:30","谢霆锋"));
        pp.put(004,new pt(004,"教室A","2021-3-3 10:20","范冰冰"));
    }
    @Autowired
    studentdao std;
    //得到地点信息
    public Collection<pt> getall(){
        return pp.values();
    }
    public Collection<student>getstudent(){
        return std.getstudent();
    }
    //通过ID查找信息
    public String get(Integer id){
        return std.get(id).getName();
    }
    public pt getfromid(Integer id){
        return pp.get(id);
    }
    //增加用户
    private static Integer InitID=005;
    public void zz(pt p){
        if (p.getID()==null){
//            if (std.getID(p.getName()).getId()!=null){
//                p.setID(std.getID(p.getName()).getId());
//            }
                p.setID(InitID++);
        }
        pp.put(p.getID(),p);
    }
    public void delete(Integer id){
        pp.remove(id);
    }
}
