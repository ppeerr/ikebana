package com.per.service.impl;

import com.per.facade.dto.ProductDto;
import com.per.facade.exception.NotFoundException;
import com.per.repository.ProductRepository;
import com.per.repository.entity.Product;
import com.per.repository.mapper.EntityMapper;
import com.per.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private EntityMapper entityMapper;

    public ProductServiceImpl(ProductRepository productRepository, EntityMapper entityMapper) {
        this.productRepository = productRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> entityMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto get(int id) {
        Product product = productRepository.findOne(id);
        if (product == null) {
            throw new NotFoundException("Can't find any product with id = " + id);
        }

        return entityMapper.map(product, ProductDto.class);
    }

    @Override
    public void create(ProductDto productDto) {
        productRepository.save(entityMapper.map(productDto, Product.class));
    }
}
