package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean save(User entity) {
//        if (entity.getName() == null) {
            return super.save(entity);
//        } else {
//            return updateById(entity);
//        }

    }
}
