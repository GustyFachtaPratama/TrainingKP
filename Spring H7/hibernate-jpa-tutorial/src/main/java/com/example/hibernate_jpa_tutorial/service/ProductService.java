package com.example.hibernate_jpa_tutorial.service;

import com.example.hibernate_jpa_tutorial.entity.Product;
import com.example.hibernate_jpa_tutorial.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Menyimpan Produk
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Mendapatkan Semua Produk
    @Cacheable("products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Mendapatkan Produk Berdasarkan ID
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
