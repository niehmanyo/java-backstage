package com.example.demo.Mapper;

import com.example.demo.Entity.Manager;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    public List<Manager> findAll();


    int register(Manager manager);


    @Select("select * from vue_tb limit #{pageNum},#{pageSize}")
    List<User> getPageInfo(Integer pageNum, Integer pageSize);

    @Select("select count(*) from vue_tb")
    Integer selectAll();


    Integer insertUser(User user);
}