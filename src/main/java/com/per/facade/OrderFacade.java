package com.per.facade;

import com.per.facade.dto.OrderDto;

import java.util.List;

public interface OrderFacade {

    List<OrderDto> getAll();

    OrderDto get(int id);

    void create(OrderDto orderDto);
}
