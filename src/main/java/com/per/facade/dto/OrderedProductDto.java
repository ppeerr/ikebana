package com.per.facade.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

//FIXME
@Data
public class OrderedProductDto {

    private Integer id;

    private Integer orderId;

    @NotNull
    private Integer productId;

    @NotNull
    private Integer amount;

}
