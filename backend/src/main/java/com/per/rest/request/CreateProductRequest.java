package com.per.rest.request;

import com.per.repository.enums.FlowersType;
import com.per.repository.enums.ProductType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {

    @NotNull
    private ProductType type;

    @NotNull
    private FlowersType flowersType;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;

}
