package com.service.Impl;

import com.dao.IUserdao;
import com.domain.Role;
import com.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import com.service.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class IUserserviceImpl implements IUserservice {

    @Autowired
    IUserdao iUserdao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询出用户信息（多表查询，角色和访问权限）
        UserInfo userInfo = null;

        userInfo = iUserdao.findByUsername(username);
        //获取到角色封装到User类中做角色参数权限（有多个角色，需要自定义一个方法封装成UserDetails中，因UserDetails是接口所以用他的子类SimpleGrantedAuthority封装）
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);

        //处理自己的对象封装成UserDetails对象返回（因为UserDetails是接口需要用他的实体类User返回 ）User封装的参数：用户名，密码，状态，账户是否过期，认证是否过期，账户是否锁定，角色
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys);

        return user;
    }
    //角色封装成UserDetails自定义方法
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList<>();
        for (Role role:roles){
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;
    }

    @Override
    public List<UserInfo> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return iUserdao.findAll(page,size);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserdao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return iUserdao.findById(id);
    }


}
