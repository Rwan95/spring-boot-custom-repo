package com.salam.custom_repo.repository;

import com.salam.custom_repo.filter.ProductFilter;
import com.salam.custom_repo.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomProductRepository {

    List<Product> findProductsOnSaleWithPriceLessThan(BigDecimal price);

    List<Product> findProductWithDynamicFilter(ProductFilter productFilter);
}
