package com.springbootacademy.pos_system.service;

import com.springbootacademy.pos_system.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
