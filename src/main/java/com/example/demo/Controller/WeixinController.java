package com.example.demo.Controller;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.Manager;
import com.example.demo.Mapper.WeixinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/weixin")
@RestController
@CrossOrigin(origins = "http://localhost:8082/")
public class WeixinController {

    @Autowired
    private WeixinMapper weixinMapper;


    @GetMapping("/menu")
    public Map<String, Object> getMenuList() {
        Map<String, Object> res = new HashMap<>();
        Integer total = weixinMapper.numberOfFoodInMenu();
        List<Food> menu = weixinMapper.getMenuList();
        res.put("total", total);
        res.put("data", menu);
        return res;
    }
}
