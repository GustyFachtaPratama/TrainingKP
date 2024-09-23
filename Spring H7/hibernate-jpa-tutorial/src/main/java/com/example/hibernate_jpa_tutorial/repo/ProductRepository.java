package com.example.hibernate_jpa_tutorial.repo;

import com.example.hibernate_jpa_tutorial.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Anda dapat menambahkan metode query kustom di sini
}
