package com.dao;

import com.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserdao {

    @Select("select*from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "com.dao.IRoledao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Select("select *from users")
    List<UserInfo> findAll(int page, int size);

    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select *from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "com.dao.IRoledao.findRoleByUserId"))
    })
    UserInfo findById(String id);
}
