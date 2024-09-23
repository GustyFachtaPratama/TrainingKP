package com.example.inheriten_mapping.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book extends MyProduct {
    private String author;

    public Book(long productId, String name, String author) {
        super(productId, name);
        this.author = author;
    }
}
