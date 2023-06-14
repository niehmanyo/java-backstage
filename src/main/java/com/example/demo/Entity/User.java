package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *   @author:niewenyu
 *
 * **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("vue_tb")
public class User {
    private String date;
    private String name;
    private String address;


}
