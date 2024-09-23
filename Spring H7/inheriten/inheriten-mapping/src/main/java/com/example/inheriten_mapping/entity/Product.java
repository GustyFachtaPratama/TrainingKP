package com.example.inheriten_mapping.entity;

import jakarta.persistence.*;

import java.util.Date;
//Anda ingin mencatat waktu terakhir entitas diakses
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date lastAccessed;
    @PostLoad//Dipanggil setelah entitas dimuat dari database.
    public void updateLastAccessed() {
        lastAccessed = new Date();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }




}
