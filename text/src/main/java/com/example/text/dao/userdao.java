package com.example.text.dao;

import com.example.text.pojo.user;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class userdao {
    public static Map<String,user>person=null;
    static {
        person=new HashMap<String,user>();
        person.put("cgx",new user("cgx","123456"));
    }
    //登录
    public user login(user u){
        user a=person.get(u.getUsername());
        if (a==null){
            return null;
        }
        else {
            if (a.getPassword().equals(u.getPassword())){
                return u;
            }
            return null;
        }
    }
    //增加用户
    public void jia(user a){
        person.put(a.getUsername(),a);
    }
}
