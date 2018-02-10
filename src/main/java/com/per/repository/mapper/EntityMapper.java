package com.per.repository.mapper;

import com.per.facade.dto.OrderDto;
import com.per.facade.dto.OrderedProductDto;
import com.per.facade.dto.ProductDto;
import com.per.repository.entity.Order;
import com.per.repository.entity.OrderedProduct;
import com.per.repository.entity.Product;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Order.class, OrderDto.class)
                .byDefault()
                .register();

        factory.classMap(Product.class, ProductDto.class)
                .byDefault()
                .register();

        factory.classMap(OrderedProduct.class, OrderedProductDto.class)
                .byDefault()
                .register();
    }

}
