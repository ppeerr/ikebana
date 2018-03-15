package com.per.facade.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private Integer id;

    @NotNull
    private String customerName;

    @NotNull
    private String phoneNumber;

    private String comment;

    @NotNull
    private String address;

    @NotNull
    private Integer weeksCount;

    @NotNull
    private SelectedDays selectedDays;

    @NotNull
    private Integer totalPrice;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @NotNull
    private List<OrderedProductDto> products;
}
