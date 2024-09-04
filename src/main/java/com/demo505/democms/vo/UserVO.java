package com.demo505.democms.vo;

//值对象，从DTO复制数据过来返回给前端
//定义决定不存在敏感数据，增强隔离安全性
public class UserVO{
    private long id;
    private String name;

    //以下都是getter和setter
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
