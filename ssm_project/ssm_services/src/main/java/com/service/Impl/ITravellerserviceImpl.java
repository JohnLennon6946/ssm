package com.service.Impl;

import com.dao.ITravellerdao;
import com.domain.Traveller;
import com.service.ITravellerservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ITravellerserviceImpl implements ITravellerservice {

    @Autowired
    ITravellerdao iTravellerdao;

    @Override
    public List<Traveller> findByOrderId(String orderId) {
        return iTravellerdao.findByOrderId(orderId);
    }
}
