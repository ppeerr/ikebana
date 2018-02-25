package com.per.facade;

import com.per.facade.dto.ProductDto;
import com.per.rest.request.CreateProductRequest;

import java.util.List;

public interface ProductFacade {

    List<ProductDto> getAll();

    ProductDto get(int id);

    void create(CreateProductRequest productDto);
}
