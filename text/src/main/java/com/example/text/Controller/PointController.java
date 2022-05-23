package com.example.text.Controller;

import com.example.text.config.GouldUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PointController {

    @Autowired
    private GouldUtil gouldUtil;

    public static final Logger log = LoggerFactory.getLogger(PointController.class);

    //根据经纬度获取地址
    @PostMapping("/getAddress")
    public String getAddress(String longitude, String lat) {
        try {
            System.out.println(longitude);
            System.out.println(lat);
            String address = gouldUtil.getAMapByLngAndLat(longitude, lat);
            return  address;
        } catch (Exception e) {
            e.printStackTrace();
            return "Aaa";
        }
    }
    //根据地址获取经纬度
    @GetMapping("/getLonLat/{address}")
    public String getLonLat(@PathVariable("address") String address) {
        try {
            String result = gouldUtil.getLonLat(address);
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            return  "aaa";
        }
    }
    //通过地址算出两个地址之间的距离
    @GetMapping("/getDistanceByAddress/{start}/{end}")
    public Long getDistanceByAddress(@PathVariable String start,@PathVariable String end){
        return gouldUtil.getDistanceByAddress(start,end);
    }

}
