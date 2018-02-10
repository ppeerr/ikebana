package com.per.rest;

import com.per.facade.OrderFacade;
import com.per.facade.dto.OrderDto;
import com.per.facade.dto.ProductDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ApiModel("Order service")
@RequestMapping(value = "/api/orders", produces = "application/json")
public class OrderController {

    private OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @ApiOperation(value = "Get all orders")
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = OrderDto.class, responseContainer = "List"),
            @ApiResponse(code = 204, message = "Can't find any order")
    })
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> products = orderFacade.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @ApiOperation(value = "Get order by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = OrderDto.class),
            @ApiResponse(code = 404, message = "Can't find the order")
    })
    public ResponseEntity<OrderDto> get(@PathVariable("id") int id) {
        OrderDto product = orderFacade.get(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new order")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductDto> create(
            @ApiParam("order dto")
            @Valid
            @RequestBody
                    OrderDto orderDto
    ) {
        orderFacade.create(orderDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
