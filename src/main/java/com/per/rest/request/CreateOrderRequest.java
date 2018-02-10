package com.per.rest.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.per.repository.enums.ScheduleType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Map;

@Data
public class CreateOrderRequest {

    @NotNull
    private String customerName;

    private String comment;

    @NotNull
    private String address;

    @NotNull
    private Integer totalPrice;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @NotNull
    private ScheduleType scheduleType;

    @NotNull
    private Map<Integer, Integer> productAmounts;

}
