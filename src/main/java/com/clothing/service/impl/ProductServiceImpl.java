package com.clothing.service.impl;

import com.clothing.entity.Product;
import com.clothing.repository.ProductRepository;
import com.clothing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
