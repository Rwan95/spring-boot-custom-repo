package com.salam.custom_repo.service;

import com.salam.custom_repo.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    List<Product> getProductsOnSaleWithPriceLessThan(BigDecimal price);

}
