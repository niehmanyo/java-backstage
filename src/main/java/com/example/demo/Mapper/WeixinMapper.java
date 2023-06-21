package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.Food;
import com.example.demo.Entity.User;

import java.util.List;

public interface WeixinMapper  extends BaseMapper<User> {

    Integer numberOfFoodInMenu();

    List<Food> getMenuList();

    Integer insertFood();
}
