package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @GetMapping(value = "/customers")
    public List<Customer>  customers(){

        return customerService.getAllCustomers();
    }


    @PostMapping(value = "/addcustomer")
    public void addCustomer(@RequestBody Customer customer){

        customerService.insert(customer);

    }

    @DeleteMapping(value = "/deletecustomer/{id}")
    public void deleteCustomer( @PathVariable Long id){

        customerService.delete(id);
    }

    @PatchMapping(value = "/updatecustomer")
    public void updateCustomer( @RequestBody Customer customer){

        customerService.update(customer, customer.getId());
    }

    @GetMapping(value="/customer/{id}")
    public Optional<Customer> getPostById(@PathVariable Long id){

        return customerService.getCustomer(id);
    }
}
