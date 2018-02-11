package com.per.repository;

import com.per.repository.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
}
