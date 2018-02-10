package com.per.facade.impl;

import com.per.facade.OrderFacade;
import com.per.facade.dto.OrderDto;
import com.per.facade.exception.NoContentException;
import com.per.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacadeImpl implements OrderFacade {

    private OrderService orderService;

    public OrderFacadeImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderDto> orders = orderService.getAll();
        if (orders.isEmpty()) {
            throw new NoContentException("Can't find any order");
        }
        return orders;
    }

    @Override
    public OrderDto get(int id) {
        return null;
    }

    @Override
    public void create(OrderDto orderDto) {
        orderService.create(orderDto);
    }
}
