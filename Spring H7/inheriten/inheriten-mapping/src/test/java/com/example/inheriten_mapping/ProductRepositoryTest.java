package com.example.inheriten_mapping;

import com.example.inheriten_mapping.entity.Product;
import com.example.inheriten_mapping.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void givenProduct_whenLoaded_thenLastAccessedUpdated() {
        // Membuat dan menyimpan entitas Product
        Product product = new Product();
        product.setName("Sample Product");
        productRepository.save(product);

        // Memuat entitas Product, yang akan memicu @PostLoad dan mengupdate lastAccessed
        Product loadedProduct = productRepository.findById(product.getId()).orElseThrow();

        // Menyimpan kembali entitas untuk memperbarui lastAccessed di database
        productRepository.save(loadedProduct);

        // Memuat kembali entitas untuk memeriksa nilai lastAccessed
        Product updatedProduct = productRepository.findById(product.getId()).orElseThrow();

        // Memastikan bahwa lastAccessed telah diperbarui
        assertThat(updatedProduct.getLastAccessed()).isNotNull();
        assertThat(updatedProduct.getLastAccessed()).isAfter(loadedProduct.getLastAccessed());
    }
}
