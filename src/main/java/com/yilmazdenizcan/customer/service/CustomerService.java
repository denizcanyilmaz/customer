package com.yilmazdenizcan.customer.service;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@Service
public class CustomerService {
    //
    // it uses repository layer transaction functions and connect
    // repository with controller layer
    // repository layer functions are built on
    //
    @Autowired
    private CustomerRepository customerRepository;

    // get all entities from customer table
    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();

    }

    // set entity to customer table
    public void insert(Customer customer) {

        customerRepository.save(customer);
    }

    // delete entity from customer table with specific id
    public boolean delete(Long id){

        customerRepository.deleteById(id);
        return true;
    }

    //update entity with new information in customer table
    public ResponseEntity<Object> update(Customer customer,Long id) {


        customer.setId(id);
        customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    // get specific customer from table
    public Optional<Customer> getCustomer(Long id) {

        return customerRepository.findById(id);
    }
}
