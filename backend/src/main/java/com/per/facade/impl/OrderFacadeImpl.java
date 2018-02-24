package com.per.facade.impl;

import com.per.facade.OrderFacade;
import com.per.facade.dto.OrderDto;
import com.per.facade.exception.NoContentException;
import com.per.facade.mapper.OrderDtoMapper;
import com.per.rest.request.CreateOrderRequest;
import com.per.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderFacadeImpl implements OrderFacade {

    private OrderService orderService;

    private OrderDtoMapper orderDtoMapper;

    public OrderFacadeImpl(OrderService orderService, OrderDtoMapper orderDtoMapper) {
        this.orderService = orderService;
        this.orderDtoMapper = orderDtoMapper;
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
    public void create(CreateOrderRequest createOrderRequest) {
        orderService.create(orderDtoMapper.map(createOrderRequest, OrderDto.class));
    }
}
