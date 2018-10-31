package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.Customer;
import com.yilmazdenizcan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/customers")
    public List<Customer>  customers(){
        return customerService.getAllCustomers();
    }


    @PostMapping(value = "/addcustomer")
    public void addCustomer(@RequestBody Customer customer){
        customerService.insert(customer);

    }
}
