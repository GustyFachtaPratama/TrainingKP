package com.example.hibernate_fect.service;

import com.example.hibernate_fect.entity.Customer;
import com.example.hibernate_fect.entity.Order;
import com.example.hibernate_fect.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.hibernate_fect.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
//
//import jakarta.transaction.Transactional;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Mengambil Customer berdasarkan ID dan mengembalikan set Order yang terkait.
     *
     * @param id ID Customer
     * @return Set<Order> yang terkait dengan Customer
     * @throws ResourceNotFoundException jika Customer tidak ditemukan
     */
    @Transactional
    public Set<Order> getCustomerOrders(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return customer.getOrders();
    }

    /**
     * Mengambil Customer berdasarkan ID tanpa mengakses orders (FetchType.LAZY).
     *
     * @param id ID Customer
     * @return Customer yang ditemukan
     * @throws ResourceNotFoundException jika Customer tidak ditemukan
     */
    @Transactional(readOnly = true)
    public Customer getCustomerLazy(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    /**
     * Mengambil Customer dan langsung mengakses orders (FetchType.EAGER).
     *
     * @param id ID Customer
     * @return Set<Order> yang terkait dengan Customer
     * @throws ResourceNotFoundException jika Customer tidak ditemukan
     */
    @Transactional(readOnly = true)
    public Set<Order> getCustomerEager(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return customer.getOrders();
    }
}
