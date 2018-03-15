package com.per.repository.mapper;

import com.per.facade.dto.OrderDto;
import com.per.facade.dto.OrderedProductDto;
import com.per.facade.dto.ProductDto;
import com.per.facade.dto.SelectedDays;
import com.per.repository.entity.Order;
import com.per.repository.entity.OrderedProduct;
import com.per.repository.entity.Product;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.BooleanUtils.toInteger;

@Component
public class EntityMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Order.class, OrderDto.class)
                .customize(new CustomMapper<Order, OrderDto>() {
                    @Override
                    public void mapAtoB(Order order, OrderDto orderDto, MappingContext context) {
                        String mask = order.getSelectedDaysMask();
                        SelectedDays selectedDays = new SelectedDays();

                        for (int i = 0; i < mask.length(); i++) {
                            char currentDay = mask.charAt(i);

                            selectedDays.setDay(i, currentDay == '1');
                        }
                        orderDto.setSelectedDays(selectedDays);

                        super.mapAtoB(order, orderDto, context);
                    }

                    @Override
                    public void mapBtoA(OrderDto orderDto, Order order, MappingContext context) {
                        StringBuilder mask = new StringBuilder();
                        SelectedDays selectedDays = orderDto.getSelectedDays();

                        for (int i = 0; i < 7; i++) {
                            mask.append(toInteger(selectedDays.getDay(i)));
                        }
                        order.setSelectedDaysMask(mask.toString());

                        super.mapBtoA(orderDto, order, context);
                    }
                })
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
