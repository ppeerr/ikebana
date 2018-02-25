package com.per.facade.impl;

import com.per.facade.ProductFacade;
import com.per.facade.dto.ProductDto;
import com.per.facade.exception.NoContentException;
import com.per.facade.mapper.ProductDtoMapper;
import com.per.rest.request.CreateProductRequest;
import com.per.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductFacadeImpl implements ProductFacade {

    private ProductService productService;

    private ProductDtoMapper productDtoMapper;

    public ProductFacadeImpl(ProductService productService, ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
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
    public void create(CreateProductRequest productDto) {
        productService.create(productDtoMapper.map(productDto, ProductDto.class));
    }
}
