package com.demo505.democms.mapper;

import org.apache.ibatis.annotations.*;

import com.demo505.democms.dto.UserDTO;

//数据库交互接口，用mybatis注解简化操作
@Mapper
public interface UserMapper {
    //id查人，返回DTO
    @Select("SELECT id,username,password FROM users WHERE id = #{id}")
    UserDTO findById(@Param("id") Long id);

    //用户名查人，返回DTO
    @Select("SELECT id,username,password FROM users WHERE USERNAME = #{username}")
    UserDTO findByName(@Param("username") String username);

    //加入新人，返回影响行数，1则是成功
    @Insert("INSERT INTO users(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);
}
