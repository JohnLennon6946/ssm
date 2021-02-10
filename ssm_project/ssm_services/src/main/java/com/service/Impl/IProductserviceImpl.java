package com.service.Impl;

import com.dao.IProductdao;
import com.domain.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.service.IProductservice;

import java.util.List;
@Service("iproductservice")
@Transactional   //@Transactional 是声明式事务管理
public class IProductserviceImpl implements IProductservice {

    @Autowired
    private IProductdao iProductdao;

    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return iProductdao.findAll(page,size);
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        iProductdao.saveProduct(product);
    }
}
