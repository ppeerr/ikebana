package com.per.facade.dto;

import lombok.Data;

//FIXME
@Data
public class OrderedProductDto {

    private Integer id;

    private OrderDto order;

    private ProductDto product;

    private Integer amount;

}
