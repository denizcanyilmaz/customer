package com.yilmazdenizcan.customer.service;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();

    }

    public void insert(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean delete(Long id){
        customerRepository.deleteById(id);
        return true;
    }

    public ResponseEntity<Object> update(Customer customer,Long id) {


        customer.setId(id);
       

        customerRepository.save(customer);

        return ResponseEntity.noContent().build();
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
