package com.service;

import com.domain.Orders;

import java.util.List;

public interface IOdersservice {
    List<Orders> findAll(int page,int size);

    Orders findById(String ordersId);
}
