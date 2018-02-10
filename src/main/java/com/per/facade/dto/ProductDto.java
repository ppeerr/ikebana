package com.per.facade.dto;

import com.per.repository.enums.ProductType;
import lombok.Data;

@Data
public class ProductDto {

    private ProductType type;

    private String name;

    private String description;

    private Integer quantity;

    private Integer price;

    private Integer id;

}
