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

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id);
    }

    public void create(Product product){
        productRepository.create(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
