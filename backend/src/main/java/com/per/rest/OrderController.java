package com.per.rest;

import com.per.facade.OrderFacade;
import com.per.facade.dto.OrderDto;
import com.per.rest.api.OrderApi;
import com.per.rest.request.CreateOrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders", produces = "application/json")
public class OrderController implements OrderApi {

    private OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> products = orderFacade.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDto> get(@PathVariable("id") int id) {
        OrderDto product = orderFacade.get(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity sendInfo(@PathVariable("id") int id) {
        orderFacade.sendInfo(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CreateOrderRequest orderRequest) {
        orderFacade.create(orderRequest);

        return new ResponseEntity(HttpStatus.OK);
    }

}
