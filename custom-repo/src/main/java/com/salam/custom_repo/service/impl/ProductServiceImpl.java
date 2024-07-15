package com.salam.custom_repo.service.impl;

import com.salam.custom_repo.model.Product;
import com.salam.custom_repo.repository.ProductRepository;
import com.salam.custom_repo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsOnSaleWithPriceLessThan(BigDecimal price) {
        return productRepository.findProductsOnSaleWithPriceLessThan(price);
    }
}
