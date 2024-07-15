package com.salam.custom_repo.repository;

import com.salam.custom_repo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, CustomProductRepository {

    List<Product> findByOnSaleIsTrueAndPriceLessThan(BigDecimal price);
}
