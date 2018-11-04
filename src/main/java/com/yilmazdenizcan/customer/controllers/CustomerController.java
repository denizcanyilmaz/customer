package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@RestController
public class CustomerController {
    //
    // it uses service layer functions and map
    // them a http response and url
    //
    @Autowired
    private CustomerService customerService;


    // calls getAllCustomers method in service layer
    // take all entities in Customer Table
    @GetMapping(value = "/customers")
    public List<Customer>  customers(){

        return customerService.getAllCustomers();
    }

    // calls insert method in service layer
    // add the entity to Customer Table
    @PostMapping(value = "/addcustomer")
    public void addCustomer(@RequestBody Customer customer){

        customerService.insert(customer);

    }

    // calls delete method in service layer
    // delete entity with id from Customer Table
    @DeleteMapping(value = "/deletecustomer/{id}")
    public void deleteCustomer( @PathVariable("id") Long id){

        customerService.delete(id);
    }

    // calls update method in service layer
    // update the entity in Customer Table
    @PatchMapping(value = "/updatecustomer")
    public void updateCustomer( @RequestBody Customer customer){

        customerService.update(customer, customer.getId());
    }

    // calls getCustomer method in service layer
    // get customer with the id from Customer Table
    @GetMapping(value="/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Long id){

        return customerService.getCustomer(id);
    }
}
