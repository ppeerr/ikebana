package com.per.service;

import com.per.facade.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAll();

    OrderDto get(int id);

    void create(OrderDto orderDto);

}
