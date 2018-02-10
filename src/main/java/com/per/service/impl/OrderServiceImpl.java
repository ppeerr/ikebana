package com.per.service.impl;

import com.per.facade.dto.OrderDto;
import com.per.facade.exception.NotFoundException;
import com.per.repository.OrderRepository;
import com.per.repository.entity.Order;
import com.per.repository.mapper.OrderMapper;
import com.per.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> orderMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto get(int id) {
        Order order = orderRepository.findOne(id);
        if (order == null) {
            throw new NotFoundException("Can't find any order with id = " + id);
        }

        return orderMapper.map(order, OrderDto.class);
    }

    @Override
    public void create(OrderDto orderDto) {

    }
}
