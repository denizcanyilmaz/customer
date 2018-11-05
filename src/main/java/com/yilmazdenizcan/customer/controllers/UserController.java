package com.yilmazdenizcan.customer.controllers;

import com.yilmazdenizcan.customer.entities.User;
import com.yilmazdenizcan.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addUser(@RequestBody User user){

        userService.insert(user);

    }

    // calls getAllUsers method in service layer
    // get all entities from User Table
    @GetMapping(value = "/users")
    public List<User> users(){

        return userService.getAllUsers();
    }

    // test for http response
    @PostMapping(value= "/deleteallusers")
    public void deleteAllUser(){
        userService.deleteAll();

    }

    // validate user and set its activate status "true"
    @PostMapping(value="/validateuser/{username}/{password}")
    public User validateUser(@PathVariable("username") String username, @PathVariable("password") String password ){

        User usr = userService.validateUser(username,password);
        System.out.println(usr.isActive());
        return usr;
    }



}
