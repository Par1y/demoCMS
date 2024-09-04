package com.demo505.demoCMS.DTO;

//数据传输对象，仅在后端操作，不会返回给前端
//基本只存储、传递数据，不做其他操作
public class UserDTO {
    private long id;
    private String username;
    private String password;

    //以下都是getter和setter
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
