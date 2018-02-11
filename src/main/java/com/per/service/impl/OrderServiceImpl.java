package com.per.service.impl;

import com.per.facade.dto.OrderDto;
import com.per.facade.exception.NotFoundException;
import com.per.repository.OrderRepository;
import com.per.repository.OrderedProductRepository;
import com.per.repository.entity.Order;
import com.per.repository.entity.OrderedProduct;
import com.per.repository.mapper.EntityMapper;
import com.per.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderedProductRepository orderedProductRepository;

    private EntityMapper entityMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderedProductRepository orderedProductRepository, EntityMapper entityMapper) {
        this.orderRepository = orderRepository;
        this.orderedProductRepository = orderedProductRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> entityMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto get(int id) {
        Order order = orderRepository.findOne(id);
        if (order == null) {
            throw new NotFoundException("Can't find any order with id = " + id);
        }

        return entityMapper.map(order, OrderDto.class);
    }

    @Override
    public void create(OrderDto orderDto) {
        //TODO fixme by JPA functionality
        Order order = entityMapper.map(orderDto, Order.class);
        orderRepository.save(order);

        orderDto.getProducts().forEach(orderedProductDto -> {
            OrderedProduct orderedProduct = entityMapper.map(orderedProductDto, OrderedProduct.class);
            orderedProduct.setOrderId(order.getId());
            orderedProductRepository.save(orderedProduct);
        });
    }
}
