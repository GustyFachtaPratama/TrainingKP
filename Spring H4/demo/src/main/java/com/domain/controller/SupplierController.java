package com.domain.controller;

import com.domain.dto.ResponseData;
import com.domain.dto.SupplierData;
import com.domain.models.entities.Supplier;
import com.domain.services.SupplierService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors){
        ResponseData<Supplier> responsedaData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responsedaData.getMessages().add(error.getDefaultMessage());
            }
            responsedaData.setStatus(false);
            responsedaData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsedaData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responsedaData.setStatus(true);
        responsedaData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responsedaData);
    }

    @GetMapping
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id") Long id){
          return supplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierData supplierData, Errors errors){
        ResponseData<Supplier> responsedaData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responsedaData.getMessages().add(error.getDefaultMessage());
            }
            responsedaData.setStatus(false);
            responsedaData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsedaData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responsedaData.setStatus(true);
        responsedaData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responsedaData);
    }
}
