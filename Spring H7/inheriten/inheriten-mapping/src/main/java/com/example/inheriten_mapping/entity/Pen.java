package com.example.inheriten_mapping.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Pen extends MyProduct {
    private String color;

    public Pen(long productId, String name,String color) {
        super(productId, name);
        this.color = color;
    }
}