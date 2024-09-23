package com.example.hibernate_fect.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Menggunakan IDENTITY
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) // FetchType.LAZY
    @Fetch(FetchMode.SELECT)
    private Set<Order> orders = new HashSet<>();

    // Getters dan Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    // Metode helper untuk mengelola hubungan
    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }
}
