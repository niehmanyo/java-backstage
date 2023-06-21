package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.Food;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.WeixinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WeixinService extends ServiceImpl<WeixinMapper, Food> {

    @Autowired
    private WeixinMapper weixinMapper;


    @Override
    public boolean save(Food entity) {
//        if (entity.getName() == null) {
        return super.save(entity);
//        } else {
//            return updateById(entity);
//        }

    }

}
