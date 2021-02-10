package com.dao;

import com.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface IRoledao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "com.dao.IPermissiondao.findPermissionById")),

    })
    List<Role> findRoleByUserId(String userId);

    @Select("select *from role")
    List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void add(Role role);

}
