package com.salam.custom_repo.repository;

import com.salam.custom_repo.filter.ProductFilter;
import com.salam.custom_repo.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomProductRepositoryImpl implements CustomProductRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductsOnSaleWithPriceLessThan(BigDecimal price) {
        String jpql = "SELECT p FROM Product p WHERE p.onSale = true AND p.price < :price";
        return entityManager.createQuery(jpql, Product.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Product> findProductWithDynamicFilter(@org.jetbrains.annotations.NotNull ProductFilter productFilter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if(productFilter.getName() != null ){
            predicates.add(cb.equal(product.get("name"), productFilter.getName()));
        }

        if(productFilter.getPrice() != null){
            predicates.add(cb.greaterThan(product.get("price"), productFilter.getPrice()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
