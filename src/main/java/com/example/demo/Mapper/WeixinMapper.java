package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.Food;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public interface WeixinMapper  extends BaseMapper<Food> {

    Integer numberOfFoodInMenu();

    List<Food> getMostPreciousPieceList();

    Integer insertMostPreciousFood(Food food);

    Integer insertFood(Food food);
    Integer deleteFood(String name);
}
