package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestMapping("/user")
@RestController

public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public List<User> getLoginManagers() {
        return userMapper.findAll();
    }

    @PostMapping("/register")
    public int register(@RequestBody User user) {
        return userMapper.register(user);
    }


    /*
     *  做分页查询
     *
     * 接口path: user/page?PageNum=1&PageSize=10 这样
     * RequestParam接受这些东西
     *
     * */
    @GetMapping("/page")
    public List<User> getPageInfo(@RequestParam Integer PageNum, @RequestParam Integer PageSize) {
        PageNum = (PageNum - 1) * PageSize;
        return userMapper.getPageInfo(PageNum, PageSize);
    }


}
