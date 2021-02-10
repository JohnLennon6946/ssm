package com.service;

import com.domain.Role;

import java.util.List;

public interface IRoleservice {
    List<Role> findRoleByUserId(String userId);

    List<Role> findAll();

    void add(Role role);
}
