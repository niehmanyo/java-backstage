package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.Manager;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {


    public List<Manager> findAll();


    int register(Manager manager);


    @Select("select * from vue_tb limit #{pageNum},#{pageSize}")
    List<User> getPageInfo(Integer pageNum, Integer pageSize);

    @Select("select count(*) from vue_tb")
    Integer selectAll();

    @Select("select count(*) from login_info")
    Integer selectAllManager();

    Integer insertUser(User user);

    @Delete("delete from vue_tb where name = #{name}")
    Integer deleteUser(String name);
}