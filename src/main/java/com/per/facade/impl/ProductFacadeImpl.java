package com.per.facade.impl;

import com.per.facade.ProductFacade;
import com.per.facade.dto.ProductDto;
import com.per.facade.exception.NoContentException;
import com.per.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> products = productService.getAll();
        if (products.isEmpty()) {
            throw new NoContentException("Can't find any product");
        }

        return products;
    }

    @Override
    public ProductDto get(int id) {
        return null;
    }

    @Override
    public void create(ProductDto productDto) {
        productService.create(productDto);
    }
}
