package com.per.rest;

import com.per.facade.ProductFacade;
import com.per.facade.dto.ProductDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiModel("Product service")
@RequestMapping(value = "/api/products", produces = "application/json") //TODO move the word 'api'
public class ProductController {

    private ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @ApiOperation("Get all products from DB")
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ProductDto.class, responseContainer = "List"),
            @ApiResponse(code = 204, message = "Can't find any product")
    })
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = productFacade.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @ApiOperation("Get product by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ProductDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Can't find the product")
    })
    public ResponseEntity<ProductDto> get(@PathVariable("id") int id) {
        ProductDto product = productFacade.get(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
