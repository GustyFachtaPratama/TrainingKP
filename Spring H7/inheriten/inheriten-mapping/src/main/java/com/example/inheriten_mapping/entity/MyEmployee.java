package com.example.inheriten_mapping.entity;

import jakarta.persistence.Entity;

@Entity
public class MyEmployee extends Person {
    private String company;

    public MyEmployee(long personId, String name, String company) {
        super(personId, name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // constructor, getters, setters
}