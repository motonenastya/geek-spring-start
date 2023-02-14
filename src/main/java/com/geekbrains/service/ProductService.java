package com.geekbrains.service;

import com.geekbrains.dao.ProductRepository;
import com.geekbrains.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
