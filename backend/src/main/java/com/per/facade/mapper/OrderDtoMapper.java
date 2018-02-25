package com.per.facade.mapper;

import com.per.facade.dto.OrderDto;
import com.per.facade.dto.OrderedProductDto;
import com.per.facade.dto.ProductDto;
import com.per.rest.request.CreateOrderRequest;
import com.per.service.ProductService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

                        int totalPrice = 0;
                        for (Map.Entry<Integer, Integer> entry : createOrderRequest.getProductAmounts().entrySet()) {
                            Integer productId = entry.getKey();
                            Integer amount = entry.getValue();
                            ProductDto productDto = productService.get(productId);

                            OrderedProductDto orderedProductDto = new OrderedProductDto();
                            orderedProductDto.setId(productId);
                            orderedProductDto.setAmount(amount);
                            orderedProductDto.setProductId(productDto.getId());

                            totalPrice += amount * productDto.getPrice();

                            orderedProducts.add(orderedProductDto);
                        }
                        orderDto.setProducts(orderedProducts);
                        orderDto.setTotalPrice(totalPrice);

                        super.mapBtoA(createOrderRequest, orderDto, context);
                    }
                })
                .byDefault()
                .register();
    }
}
