package com.domain.controller;

import com.domain.dto.ResponseData;
import com.domain.dto.SearchData;
import com.domain.dto.SupplierData;
import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import com.domain.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired //injection (controller memanggil service, service memanggil repositori)
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){ //product akan dipanggil di reques bodynya dari aplikasi client yang panggil

        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }// cetak di consol
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product)); //masih bisa terjADI MASLAAH
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findALl();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }// cetak di consol
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product)); //masih bisa terjADI MASLAAH
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productService.removeOne(id);
    }

    @PostMapping("/{id}")
    public void addSupplier(@RequestBody Supplier supplier, @PathVariable("id") Long prodictId){
        productService.addSupplier(supplier,prodictId);
    }

    @PostMapping("/search/name")
    public Product getProductByName(@RequestBody SearchData searchData){
        return productService.findByProductName(searchData.getSearchKey());
    }

    @PostMapping("/search/namelike")
    public List<Product> getProductByNameLike(@RequestBody SearchData searchData){
        return productService.findByProductNameLike(searchData.getSearchKey());
    }

    @GetMapping("/search/category/{categoryId}")
    public List<Product> getProductByNameLike(@PathVariable("categoryId") Long categoryId){
        return productService.findByProductCategory(categoryId);
    }

    @GetMapping("/search/supplier/{supplierId}")
    public List<Product> getProductBySupplier(@PathVariable("supplierId") Long supplierId){
        return productService.findBySupplier(supplierId);
    }
}
