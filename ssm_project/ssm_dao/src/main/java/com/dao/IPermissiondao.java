package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPermissiondao {

    @Select("select *from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionById(String id);

    @Select("select *from permission")
    List<Permission> findAll();
}
