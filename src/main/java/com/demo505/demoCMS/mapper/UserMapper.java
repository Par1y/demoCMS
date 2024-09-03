package com.demo505.demoCMS.mapper;

import com.demo505.demoCMS.DO.UserDO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT id,username,password FROM users WHERE id = #{id}")
    UserDO findById(@Param("id") Long id);

    @Select("SELECT id,username,password FROM users WHERE NAME = #{username}")
    UserDO findByName(@Param("username") String username);

    @Insert("INSERT INTO users(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);
}
