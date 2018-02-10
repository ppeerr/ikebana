package com.per.repository.mapper;

import com.per.facade.dto.OrderDto;
import com.per.repository.entity.Order;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Order.class, OrderDto.class)
                .byDefault()
                .register();
    }
}
