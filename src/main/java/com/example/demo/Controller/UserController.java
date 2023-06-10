package com.example.demo.Controller;


import com.example.demo.Entity.Manager;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")      //本地跨域解决问题，允许这个域名访问
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public Map<String, Object> getLoginManagers() {
        Map<String, Object> res = new HashMap<>();
        Integer total = userMapper.selectAllManager();
        List<Manager> list = userMapper.findAll();
        res.put("total",total);
        res.put("data", list);
        return res;
    }

    @PostMapping("/register")
    public int register(@RequestBody Manager manager) {
        return userMapper.register(manager);
    }


    @PostMapping("/insert")
    public int insertUser(@RequestBody User user) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String mysqlDate = sdf.format(dt);
        user.setDate(mysqlDate);
        return userMapper.insertUser(user);
    }

    /*
     *  做分页查询
     *
     * 接口path: user/page?PageNum=1&PageSize=10 这样
     * RequestParam接受这些东西
     *
     * */
    @GetMapping("/page")
    public Map<String, Object> getPageInfo(@RequestParam Integer PageNum, @RequestParam Integer PageSize) {
        PageNum = (PageNum - 1) * PageSize;
        Integer total = userMapper.selectAll();
        Map<String, Object> res = new HashMap<>();
        List<User> data = userMapper.getPageInfo(PageNum, PageSize);
        res.put("total", total);
        res.put("data", data);
        return res;
    }


}
