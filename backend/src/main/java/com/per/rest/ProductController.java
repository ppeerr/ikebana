package com.per.rest;

import com.per.facade.ProductFacade;
import com.per.facade.dto.ProductDto;
import com.per.rest.api.ProductApi;
import com.per.rest.request.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductController implements ProductApi {

    private ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

//    @CrossOrigin(origins = "http://176.213.211.47:9090")
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = productFacade.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDto> get(@PathVariable("id") int id) {
        ProductDto product = productFacade.get(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CreateProductRequest productDto) {
        productFacade.create(productDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
