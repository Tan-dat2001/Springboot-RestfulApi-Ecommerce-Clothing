package com.clothing.service;

import com.clothing.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product createProduct(Product product);

    Product editProduct(Product product);

    void deleteProductById(Long id);

}
