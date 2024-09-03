package com.demo505.demoCMS.core.web;

import com.demo505.demoCMS.core.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//不是很懂，但是大概知道重写了默认的返回处理器
@ControllerAdvice(basePackages = "com.demo505.demoCMS.Controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //CommonResult直接返回
        if(body instanceof CommonResult) {
            return body;
        }
        //不是就包装
        return CommonResult.success(body);
    }
}