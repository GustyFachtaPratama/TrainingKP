package com.example.hibernate_fect.controller;

import com.example.hibernate_fect.entity.Customer;
import com.example.hibernate_fect.entity.Order;
import com.example.hibernate_fect.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    /**
     * Endpoint untuk mendapatkan Order berdasarkan ID Customer.
     *
     * @param id ID Customer
     * @return Respons berisi set Order
     */
    @GetMapping("/{id}/orders")
    public ResponseEntity<Set<Order>> getCustomerOrders(@PathVariable Long id) {
        Set<Order> orders = customerService.getCustomerOrders(id);
        return ResponseEntity.ok(orders);
    }

    /**
     * Endpoint untuk mengambil Customer tanpa mengakses orders (FetchType.LAZY).
     *
     * @param id ID Customer
     * @return Respons Customer
     */
    @GetMapping("/{id}/lazy")
    public ResponseEntity<Customer> getCustomerLazy(@PathVariable Long id) {
        Customer customer = customerService.getCustomerLazy(id);
        return ResponseEntity.ok(customer);
    }

    /**
     * Endpoint untuk mengambil Customer dan orders secara EAGER (FetchType.EAGER).
     *
     * @param id ID Customer
     * @return Respons Set<Order>
     */
    @GetMapping("/{id}/eager")
    public ResponseEntity<Set<Order>> getCustomerEager(@PathVariable Long id) {
        Set<Order> orders = customerService.getCustomerEager(id);
        return ResponseEntity.ok(orders);
    }
}

