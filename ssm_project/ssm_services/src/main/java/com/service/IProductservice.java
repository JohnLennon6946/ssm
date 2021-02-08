package com.service;

import com.domain.Product;

import java.util.List;

public interface IProductservice {
    //查询所有的产品信息
    public List<Product> findAll() throws Exception;

    //新建商品
    public void saveProduct(Product product) throws Exception;
}
