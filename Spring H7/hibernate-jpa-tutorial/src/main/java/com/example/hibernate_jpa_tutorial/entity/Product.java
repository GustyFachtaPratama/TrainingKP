package com.example.hibernate_jpa_tutorial.entity;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "products")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    // Constructors
    public Product() {}

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getters dan Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }
}
