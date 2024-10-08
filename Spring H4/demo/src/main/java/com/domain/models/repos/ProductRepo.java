package com.domain.models.repos;

import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//DAO nya agar bisa di CRUD di controller
public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p where p.name = :name") //Product itu adalah Entity di Java, name itu field nya
    public Product findProductByName(@PathParam("name") String name); // seperti like untuk searcing

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);
}
