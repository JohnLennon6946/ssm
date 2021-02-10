package com.controller;

import com.dao.IRoledao;
import com.domain.Role;
import com.service.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class Rolecontroller {
    @Autowired
    IRoleservice iRoleservice;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Role> roleList = iRoleservice.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Role role){
        iRoleservice.add(role);
        return "redirect:findAll.do";
    }
}
