package com.demo505.democms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

//默认页面路由
@Controller
public class RouterController {
    //引入日志
    private static final Logger logger = LoggerFactory.getLogger(RouterController.class);
    @GetMapping("/")
    public String getMainpage(HttpServletRequest request) {
        String message = "访问主页，ip:"+request.getRemoteAddr();
        logger.info(message);
        return "forward:index.html";
}
}