package com.demo505.demoCMS.controller;

import com.demo505.demoCMS.core.vo.CommonResult;
import com.demo505.demoCMS.vo.UserVO;
import com.demo505.demoCMS.DO.UserDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DatabaseController DatabaseController;
    //（内部）使用id查询用户接口
    @GetMapping("/")
    public UserVO getUser(@RequestParam("id") Long id) {
        UserDO userDO = DatabaseController.findById(id);
        if (userDO == null) {
            logger.error("User with id {} not found", id);
            // 返回一个错误结果或者处理方式
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getId());
        userVO.setName(userDO.getName());
        return userVO;
    }

    // 登录接口
    @PostMapping("/login")
    public CommonResult<UserVO> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserDO userDO = DatabaseController.findByName(username);
        if (userDO == null) {
            logger.error("User with username {} not found", username);
            return CommonResult.error(-1, "用户不存在");
        }
        if (!userDO.getPassword().equals(password)) {
            logger.error("Password incorrect for user {}", username);
            return CommonResult.error(-1, "密码错误");
        }
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getId());
        userVO.setName(userDO.getName());
        return CommonResult.success(userVO);
    }
}