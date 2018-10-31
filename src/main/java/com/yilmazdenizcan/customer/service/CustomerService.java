package com.yilmazdenizcan.customer.service;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
