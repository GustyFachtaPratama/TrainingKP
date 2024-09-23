package com.example.inheriten_mapping.repo;

import com.example.inheriten_mapping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Metode query tambahan jika diperlukan
}
