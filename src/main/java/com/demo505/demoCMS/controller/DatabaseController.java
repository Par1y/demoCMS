package com.demo505.demoCMS.controller;

import com.demo505.demoCMS.DTO.UserDTO;
import com.demo505.demoCMS.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//数据库控制器，服务类
@Service
public class DatabaseController {
    //注入userMapper进行数据库交互
    @Autowired
    private UserMapper userMapper;

    //id找人，有则返回该用户DTO，没有则空返回
    public UserDTO findById(Long id) {
        return userMapper.findById(id);
    }

    //用户名找人，有则返回该用户DTO，没有则空返回
    public UserDTO findByName(String name){
        return userMapper.findByName(name);
    }

    //加入新人，只返回结果（influenced rows）
    public int insert(String name, String password){
        return userMapper.insert(name, password);
    }
}
