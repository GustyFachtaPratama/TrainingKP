package com.example.inheriten_mapping.entity;

import jakarta.persistence.*;

@Entity(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "product_type",
        discriminatorType = DiscriminatorType.INTEGER
)
public class MyProduct {
    @Id
    private long productId;
    private String name;

    public MyProduct(long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor, getters, setters
}
