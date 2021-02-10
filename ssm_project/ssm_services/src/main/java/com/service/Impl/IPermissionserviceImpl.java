package com.service.Impl;

import com.dao.IPermissiondao;
import com.domain.Permission;
import com.service.IPermissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IPermissionserviceImpl implements IPermissionservice {
    @Autowired
    IPermissiondao iPermissiondao;

    @Override
    public List<Permission> findAll() {
        return iPermissiondao.findAll();
    }
}
