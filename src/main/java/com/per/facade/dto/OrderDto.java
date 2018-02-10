package com.per.facade.dto;

import com.per.repository.enums.ScheduleType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class OrderDto {

    @NotNull
    private String customerName;

    private String comment;

    @NotNull
    private String address;

    @NotNull
    private Integer totalPrice;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private ScheduleType schedule;
}
