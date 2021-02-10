package com.service;

import com.domain.Traveller;

import java.util.List;

public interface ITravellerservice {
    List<Traveller> findByOrderId(String orderId);
}
