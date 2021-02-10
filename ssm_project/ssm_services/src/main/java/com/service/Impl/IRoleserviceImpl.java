package com.service.Impl;

import com.dao.IRoledao;
import com.domain.Role;
import com.service.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleserviceImpl implements IRoleservice {

    @Autowired
    IRoledao iRoledao;

    @Override
    public List<Role> findRoleByUserId(String userId) {
        return iRoledao.findRoleByUserId(userId);
    }

    @Override
    public List<Role> findAll() {
        return iRoledao.findAll();
    }

    @Override
    public void add(Role role) {
        iRoledao.add(role);
    }
}
