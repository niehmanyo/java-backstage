package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestMapping("/user")
@RestController

public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public List<User> getList() {
        return userMapper.findAll();
    }

    @PostMapping("/register")
    public int register(@RequestBody User user) {
        return userMapper.register(user);
    }


}
