package com.controller;

import com.domain.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.service.IProductservice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
@RequestMapping("/product")
public class Productcontroller {
    @Autowired
    private IProductservice iProductservice;

    //查询商品的方法
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(value = "size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> productList = iProductservice.findAll(page,size);
        PageInfo pageInfo=new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }

    //新建商品的方法
    @RequestMapping("save.do")
    public String saveProduct(Product product) throws Exception{
        iProductservice.saveProduct(product);
        return "redirect:findAll.do";
    }

}
