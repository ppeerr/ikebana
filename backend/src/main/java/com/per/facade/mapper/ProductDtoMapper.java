package com.per.facade.mapper;

import com.per.facade.dto.ProductDto;
import com.per.rest.request.CreateProductRequest;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(ProductDto.class, CreateProductRequest.class)
                .byDefault()
                .register();

        super.configure(factory);
    }
}
