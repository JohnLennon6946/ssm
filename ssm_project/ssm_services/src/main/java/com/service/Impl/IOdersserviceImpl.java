package com.service.Impl;

import com.dao.IOdersdao;
import com.domain.Orders;
import com.github.pagehelper.PageHelper;
import com.service.IOdersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOdersserviceImpl implements IOdersservice {

    @Autowired
    IOdersdao iOdersdao;

    @Override
    public List<Orders> findAll(int page,int size) {
        //第一个参数是页码值，第二个参数每页显示的条数,该语句必须写在真正需要调用查询的代码之前
        PageHelper.startPage(page,size);
        return iOdersdao.findAll(page,size);
    }

    @Override
    public Orders findById(String ordersId) {
        return iOdersdao.findById(ordersId);
    }
}
