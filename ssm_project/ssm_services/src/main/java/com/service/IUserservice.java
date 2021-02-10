package com.service;

import com.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserservice extends UserDetailsService {

    List<UserInfo> findAll(int page, int size);

    void save(UserInfo userInfo);

    UserInfo findById(String id);
}
