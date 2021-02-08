package com.controller;

import com.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> all = iProductservice.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list");
        return mv;
    }

    //新建商品的方法
    @RequestMapping("save.do")
    public String saveProduct(Product product) throws Exception{
        iProductservice.saveProduct(product);
        return "redirect:findAll.do";
    }

}
