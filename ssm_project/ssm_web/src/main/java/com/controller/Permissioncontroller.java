package com.controller;

import com.domain.Permission;
import com.service.IPermissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class Permissioncontroller {
    @Autowired
    IPermissionservice iPermissionservice;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = iPermissionservice.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
}
