package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    public List<User> findAll();


    int register(User user);


    @Select("select * from login_info limit #{pageNum},#{pageSize}")
    List<User> getPageInfo(Integer pageNum, Integer pageSize);
}