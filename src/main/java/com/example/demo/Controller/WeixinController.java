package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Entity.Food;
import com.example.demo.Mapper.WeixinMapper;
import com.example.demo.Service.WeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/weixin")
@RestController
@CrossOrigin(origins = {"http://localhost:8082/", "http://localhost:5173/"})
public class WeixinController {

    @Autowired
    private WeixinMapper weixinMapper;

    @Autowired
    private WeixinService weixinService;


    @GetMapping("/menu")
    public Map<String, Object> getMenuList() {
        Map<String, Object> res = new HashMap<>();
        Integer total = weixinMapper.numberOfFoodInMenu();
        List<Food> menu = weixinMapper.getMostPreciousPieceList();
        res.put("total", total);
        res.put("data", menu);
        return res;
    }

    @PostMapping("/insertPrecious")
    public Integer insertPrecious(@RequestBody Food food){
        return weixinMapper.insertMostPreciousFood(food);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody Food food){
        return weixinMapper.insert(food);
    }

    @GetMapping("/page")
    public IPage<Food> getPageInfo(@RequestParam Integer PageNum,
                                   @RequestParam Integer PageSize,
                                   @RequestParam(defaultValue = "") String foodName) {
//        这是 Mybatis 里面的写法
//        PageNum = (PageNum - 1) * PageSize;
//        Integer total = userMapper.selectAll();
//        Map<String, Object> res = new HashMap<>();
//        List<User> data = userMapper.getPageInfo(PageNum, PageSize);
//        res.put("total", total);
//        res.put("data", data);
        IPage<Food> page = new Page<>(PageNum, PageSize);
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        if (!"".equals(foodName)){
            queryWrapper.like("name",foodName);
        }
        return weixinService.page(page,queryWrapper);
        // 这边接口回调一定要看他返回的类型，之前我声明是 data，现在用了 page 是 records，所以在前端一定要改逻辑
    }
    
    @DeleteMapping("/del/{name}")
    public Integer deleteFood(@PathVariable("name") String name){
        return weixinMapper.deleteFood(name);
    };

}
