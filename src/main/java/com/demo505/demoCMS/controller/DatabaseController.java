package com.demo505.demoCMS.controller;

import com.demo505.demoCMS.DO.UserDO;
import com.demo505.demoCMS.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseController {
    @Autowired
    private UserMapper userMapper;

    public UserDO findById(Long id) {
        return userMapper.findById(id);
    }

    public UserDO findByName(String name){
        return userMapper.findByName(name);
    }

    public int insert(String name, String password){
        return userMapper.insert(name, password);
    }
}
