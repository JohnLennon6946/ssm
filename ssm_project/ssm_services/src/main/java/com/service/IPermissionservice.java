package com.service;

import com.domain.Permission;

import java.util.List;

public interface IPermissionservice {
    List<Permission> findAll();
}
