package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.User;
import com.yilmazdenizcan.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping(value = "/add")
    @ResponseStatus(value= HttpStatus.OK)
    public void addUser(@RequestBody User user){
        userService.insert(user);

    }

    // calls getAllUsers method in service layer
    // get all entities from User Table
    @GetMapping(value = "/users")
    public List<User> users(){

        return userService.getAllUsers();
    }
}
