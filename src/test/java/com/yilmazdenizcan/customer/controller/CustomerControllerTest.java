package com.yilmazdenizcan.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yilmazdenizcan.customer.controllers.CustomerController;
import com.yilmazdenizcan.customer.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;
import static org.mockito.BDDMockito.*;
/*
 *
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 * */

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    //to mock the Customer Controller layer code for our unit tests
    //by the way,it tests service methods also
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerController customerController;

    //customer creation function for other methods usage
    private Customer createCustomer(){
        Long id = Long.parseLong("10");
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Ali");
        customer.setSurname("Veli");
        customer.setIdentityNumber("1111111");
        customer.setPhoneNumber("55555555");
        customer.setJob("Engineer");
        return customer;
    }

    //it tests customers() method in controller
    //check the right size of list and customers name
    //and http response code
    @Test
    public void testAllCustomers() throws Exception {
        Customer customer = createCustomer();
        List<Customer> allcustomers = Collections.singletonList(customer);

        given(customerController.customers()).willReturn(allcustomers);

        mvc.perform(get("/customers").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(customer.getName())))
                .andDo(MockMvcResultHandlers.print());
    }

    //it tests addcustomer() method in controller
    //check the http response code
    @Test
    public void testAddCustomer() throws Exception {
        Customer customer = createCustomer();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(customer);

        mvc.perform(post("/addcustomer")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //it tests getCustomerById(id) method in controller
    //check the http response code
    @Test
    public void testGetCustomerById() throws Exception{
        Long id = Long.parseLong("10");

        mvc.perform(get("/customer/{id}",id).accept(MediaType.APPLICATION_JSON).contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //it tests deleteCustomer(id) method in controller
    //check the http response code
    @Test
    public void testDeleteCustomer() throws Exception {
        mvc.perform(delete("/deletecustomer/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    //it tests updateCustomer() method in controller
    //check the http response code
    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = createCustomer();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(customer);

        mvc.perform(post("/addcustomer").content(json));

        Customer customer2 = createCustomer();
        customer2.setName("AAAA");
        ObjectMapper objectMapper2 = new ObjectMapper();
        String json2 = objectMapper2.writeValueAsString(customer2);


        mvc.perform(patch("/updatecustomer")
                .content(json2)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }








}
