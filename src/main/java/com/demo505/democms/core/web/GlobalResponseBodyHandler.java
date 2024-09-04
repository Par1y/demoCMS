package com.demo505.democms.core.web;

import com.demo505.democms.core.vo.CommonResult;

import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.lang.NonNull;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//不是很懂，但是大概知道重写了默认的返回处理器
@ControllerAdvice(basePackages = "com.demo505.demoCMS.Controller.UserController")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {
    
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        //CommonResult直接返回
        if(body instanceof CommonResult) {
            return body;
        }
        //不是就包装
        return CommonResult.success(body);
    }
}