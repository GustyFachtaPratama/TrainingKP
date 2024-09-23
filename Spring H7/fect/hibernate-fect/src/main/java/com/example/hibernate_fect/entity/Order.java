package com.example.hibernate_fect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Menggunakan IDENTITY
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER) // FetchType.LAZY
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Getters dan Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
