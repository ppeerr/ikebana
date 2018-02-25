package com.per.rest.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.per.repository.enums.ScheduleType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Map;

@Data
public class CreateOrderRequest {

    @NotNull
    private String customerName;

    @NotNull //TODO validation
    private String phoneNumber;

    private String comment;

    @NotNull
    private String address;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @NotNull
    private ScheduleType scheduleType;

    @Size(min = 1)
    private Map<Integer, Integer> productAmounts;

}
