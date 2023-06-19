package com.example.demo.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Entity.Manager;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :Wayne.Nie
 * UserController: 封装好的函数，前端接口访问该文件的路径来访问数据库
 * */



@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")      //本地跨域解决问题，允许这个域名访问
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Map<String, Object> getLoginManagers() {
        Map<String, Object> res = new HashMap<>();
        Integer total = userMapper.selectAllManager();
        List<Manager> list = userMapper.findAll();
        res.put("total", total);
        res.put("data", list);
        return res;
    }

    @PostMapping("/register")
    public int register(@RequestBody Manager manager) {
        return userMapper.register(manager);
    }


    @PostMapping("/insert")
    public boolean insertUser(@RequestBody User user) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String mysqlDate = sdf.format(dt);
        user.setDate(mysqlDate);
        return userService.save(user);
        
    }

    @GetMapping("/search")
    public boolean searchUser(@RequestParam String username,@RequestParam String foodName){
        return Boolean.TRUE;
    }


    /*
     *  做分页查询
     *
     * 接口path: user/page?PageNum=1&PageSize=10 这样
     * RequestParam接受这些东西
     *
     * */
    @GetMapping("/page")
    public IPage<User> getPageInfo(@RequestParam Integer PageNum,
                                   @RequestParam Integer PageSize,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String foodName) {
//        这是 Mybatis 里面的写法
//        PageNum = (PageNum - 1) * PageSize;
//        Integer total = userMapper.selectAll();
//        Map<String, Object> res = new HashMap<>();
//        List<User> data = userMapper.getPageInfo(PageNum, PageSize);
//        res.put("total", total);
//        res.put("data", data);
        IPage<User> page = new Page<>(PageNum, PageSize);
        System.out.println(name);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)){
            queryWrapper.like("name",name);
        }
        return userService.page(page,queryWrapper);
        // 这边接口回调一定要看他返回的类型，之前我声明是 data，现在用了 page 是 records，所以在前端一定要改逻辑
    }


}
