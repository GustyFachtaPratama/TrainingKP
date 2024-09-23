package com.domain.services;

import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import com.domain.models.repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//berisi bisnis logic
@Service
@Transactional
public class ProductService {

    @Autowired //depedensi injection
    private ProductRepo productRepo; //object

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return  product.get();
    }

    public Iterable<Product> findALl(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }


    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findOne(productId);
        if (product == null) {
            throw new RuntimeException("Product with ID: "+productId+" not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public Product findByProductName(String name){
        return productRepo.findProductByName(name);
    }

    public List<Product> findByProductNameLike(String name){
        return productRepo.findProductByNameLike("%"+name+"%");
    }

    public List<Product> findByProductCategory(Long categoryId){
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findBySupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if(supplier == null){
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
