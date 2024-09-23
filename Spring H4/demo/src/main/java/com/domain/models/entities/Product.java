package com.domain.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tbl_product")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Product implements Serializable {

    private static final long serialVersionID = 1L;
    @Id // untuk primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// untuk auto increment
    private Long id;
    @NotEmpty(message = "Nama harus di isi!")
    @Column(name="product_name", length = 100)
    private String name;

    @NotEmpty(message = "Description harus di isi!")
    @Column(name="product_description", length = 500)
    private String description;
    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "tbl_product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id"))

    //@JsonManagedReference //agar tidak loop datanya
    private Set<Supplier> suppliers;

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Product(){

    }//contructor

    public  Product(Long id, String name, String description, double price){
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
    }//contructor dengan parameter

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
