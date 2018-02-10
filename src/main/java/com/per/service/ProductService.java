package com.per.service;

import com.per.facade.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto get(int id);

}
