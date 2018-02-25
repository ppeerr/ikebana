package com.per.rest.api;

import com.per.facade.dto.ProductDto;
import com.per.rest.request.CreateProductRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ApiModel("Product service")
public interface ProductApi {

    @ApiOperation("Get all products from DB")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ProductDto.class, responseContainer = "List"),
            @ApiResponse(code = 204, message = "Can't find any product")
    })
    ResponseEntity<List<ProductDto>> getAll();

    @ApiOperation("Get product by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ProductDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Can't find the product")
    })
    ResponseEntity<ProductDto> get(int id);

    @ApiOperation(value = "Create new product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
    })
    ResponseEntity create(@ApiParam("product dto") CreateProductRequest productDto);

}
