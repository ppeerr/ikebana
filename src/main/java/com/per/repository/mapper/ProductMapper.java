package com.per.repository.mapper;

import com.per.facade.dto.ProductDto;
import com.per.repository.entity.Product;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Product.class, ProductDto.class)
                .byDefault()
                .register();
    }
}
