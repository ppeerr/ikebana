package com.per.facade.dto;

import com.per.repository.enums.ProductType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDto {

    private Integer id;

    @NotNull
    private ProductType type;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;

}
