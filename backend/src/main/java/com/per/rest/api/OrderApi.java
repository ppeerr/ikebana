package com.per.rest.api;

import com.per.facade.dto.OrderDto;
import com.per.rest.request.CreateOrderRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ApiModel("Order service")
public interface OrderApi {

    @ApiOperation(value = "Get all orders")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = OrderDto.class, responseContainer = "List"),
            @ApiResponse(code = 204, message = "Can't find any order")
    })
    ResponseEntity<List<OrderDto>> getAll();

    @ApiOperation(value = "Get order by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = OrderDto.class),
            @ApiResponse(code = 404, message = "Can't find the order")
    })
    ResponseEntity<OrderDto> get(@ApiParam("order id") int id);

    @ApiOperation(value = "Send order info to related phone number by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = OrderDto.class),
            @ApiResponse(code = 404, message = "Can't find the order")
    })
    ResponseEntity sendInfo(@ApiParam("order id") int id);

    @ApiOperation(value = "Create new order")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
    })
    ResponseEntity create(@ApiParam("order dto") CreateOrderRequest orderRequest);
}
