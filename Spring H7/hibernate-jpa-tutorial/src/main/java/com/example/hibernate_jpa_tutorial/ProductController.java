package com.example.hibernate_jpa_tutorial;

import com.example.hibernate_jpa_tutorial.entity.Product;
import com.example.hibernate_jpa_tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Membuat Produk Baru
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Mendapatkan Semua Produk
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Mendapatkan Produk Berdasarkan ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}

