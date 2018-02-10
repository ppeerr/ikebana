package com.per.facade.mapper;

import com.per.facade.dto.OrderDto;
import com.per.facade.dto.OrderedProductDto;
import com.per.rest.request.CreateOrderRequest;
import com.per.service.ProductService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDtoMapper extends ConfigurableMapper {

    private final ProductService productService;

    public OrderDtoMapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(OrderDto.class, CreateOrderRequest.class)
                .customize(new CustomMapper<OrderDto, CreateOrderRequest>() {
                    @Override
                    public void mapBtoA(CreateOrderRequest createOrderRequest, OrderDto orderDto, MappingContext context) {
                        List<OrderedProductDto> orderedProducts = new ArrayList<>();

                        createOrderRequest.getProductAmounts().forEach((productId, amount) -> {
                            OrderedProductDto orderedProductDto = new OrderedProductDto();
                            orderedProductDto.setId(productId);
                            orderedProductDto.setProduct(productService.get(productId));
                            orderedProductDto.setAmount(amount);
                            orderedProductDto.setOrder(orderDto);

                            orderedProducts.add(orderedProductDto);
                        });
                        orderDto.setProducts(orderedProducts);

                        super.mapBtoA(createOrderRequest, orderDto, context);
                    }
                })
                .byDefault()
                .register();
    }
}
