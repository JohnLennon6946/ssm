package com.controller;

import com.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//这是管理查询所有用户信息的controller
@Controller
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    IUserservice iUserservice;

    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
        iUserservice.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(value = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userList = iUserservice.findAll(page,size);
        PageInfo pageInfo=new PageInfo(userList);
        mv.addObject("userList",pageInfo);
        mv.setViewName("users-list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=iUserservice.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("users-detail");
        return mv;
    }
}
