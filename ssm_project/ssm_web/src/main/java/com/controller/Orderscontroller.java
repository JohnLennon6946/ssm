package com.controller;

import com.domain.Orders;
import com.github.pagehelper.PageInfo;
import com.service.IOdersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class Orderscontroller {
    @Autowired
    IOdersservice iOdersservice;

    //未分页方式查询全部订单
//    @RequestMapping("findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView mv=new ModelAndView();
//        List<Orders> ordersList = iOdersservice.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page",required = true,defaultValue = "1")int page,
            @RequestParam(value = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = iOdersservice.findAll(page, size);
        //pageinfo 就是一个分页bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(value = "id",required = true)String ordersId){
        ModelAndView mv=new ModelAndView();
        Orders orders = iOdersservice.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-detail");
        return mv;
    }
}
