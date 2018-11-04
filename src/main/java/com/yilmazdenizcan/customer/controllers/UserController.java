package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.User;
import com.yilmazdenizcan.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@RestController
public class UserController {

    // it uses service layer functions and map
    // them a http response and url

    @Autowired
    private UserService userService;

    // calls insert method in service layer
    // add the entity to User Table
    @PostMapping(value = "add")
    public void addUser(@RequestBody User user){

        userService.insert(user);

    }

    // calls getAllUsers method in service layer
    // get all entities from User Table
    @GetMapping(value = "/users")
    public List<User> users(){

        return userService.getAllUsers();
    }

    @PostMapping(value= "/deleteallusers")
    public void deleteAllUser(){
        userService.deleteAll();

    }

    @PostMapping(value="/validateuser")
    public User validateCustomer(@PathVariable String username, @PathVariable String password ){

        return userService.validateUser(username,password);
    }
}
