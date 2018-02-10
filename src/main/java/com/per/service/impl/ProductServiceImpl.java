package com.per.service.impl;

import com.per.facade.dto.ProductDto;
import com.per.facade.exception.NotFoundException;
import com.per.repository.ProductRepository;
import com.per.repository.entity.Product;
import com.per.repository.mapper.ProductMapper;
import com.per.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> productMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto get(int id) {
        Product product = productRepository.findOne(id);
        if (product == null) {
            throw new NotFoundException("Can't find any product with id = " + id);
        }

        return productMapper.map(product, ProductDto.class);
    }
}
