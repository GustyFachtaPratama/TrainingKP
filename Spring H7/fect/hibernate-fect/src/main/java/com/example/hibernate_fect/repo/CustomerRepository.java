package com.example.hibernate_fect.repo;

import com.example.hibernate_fect.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Metode query tambahan jika diperlukan
}
