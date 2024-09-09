package com.demo505.democms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.demo505.democms.core.vo.CommonResult;
import com.demo505.democms.dto.UserDTO;
import com.demo505.democms.vo.UserVO;


//用户控制器，此类负责用户接口的处理和返回
@RestController

//主接口"/user"
@RequestMapping("/user")

public class UserController {
    //引入日志对象
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    //Spring注入数据库控制服务Bean
    @Autowired
    private DatabaseController databaseController;
    
    //使用id查询用户接口
    @GetMapping("/")
    public CommonResult<UserVO> getUser(@RequestParam("id") Long id) {
        UserDTO userDO = databaseController.findById(id);
        if (userDO == null) {
            logger.error("User with id {} not found", id);
            // 查无此人
            return CommonResult.error(-1, "用户不存在");
        }
        //复制DTO数据至VO并返回至前端
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getId());
        userVO.setName(userDO.getName());
        return CommonResult.success(userVO);
    }

    // 登录接口
    @PostMapping("/login")
    public CommonResult<UserVO> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserDTO userDO = databaseController.findByName(username);
        if (userDO == null) {
            logger.error("User with username {} not found", username);
            //查无此人
            return CommonResult.error(-1, "用户不存在");
        }
        if (!userDO.getPassword().equals(password)) {
            //密码不同
            logger.error("Password incorrect for user {}", username);
            return CommonResult.error(-1, "密码错误");
        }
        //复制DTO数据至VO并返回至前端
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getId());
        userVO.setName(userDO.getName());
        return CommonResult.success(userVO);
    }

    //注册接口
    @PostMapping("/register")
    public CommonResult<UserVO> register(@RequestParam("username") String username, @RequestParam("password") String password) {
        final int result = databaseController.insert(username, password);
        if(result != 1) {
            logger.error("用户注册出错：{}", username);
            //没改动那就是没注册上
            return CommonResult.error(-2, "注册失败");
        }else{
            logger.info("已注册用户：{}", username);
            //注册上了返回一下用户VO,其实空对象返回也可以，只要code：0就是成功结果
            UserDTO userDO = databaseController.findByName(username);
            //复制DTO数据至VO并返回给前端
            UserVO userVO = new UserVO();
            userVO.setName(userDO.getName());
            userVO.setId(userDO.getId());
            return CommonResult.success(userVO);
        }
    }
}