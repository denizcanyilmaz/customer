package com.yilmazdenizcan.customer.service;

import com.yilmazdenizcan.customer.entities.User;
import com.yilmazdenizcan.customer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@Service
public class UserService {
    //
    // it uses repository layer transaction functions and connect
    // repository with controller layer
    // repository layer functions are built on
    //
    @Autowired
    private UserRepository userRepository;

    // set entity to user table
    public void insert(User user) {

        userRepository.save(user);
    }

    // get all entities from customer table
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    // validate user for authorization
    public void validateUser(String name, String password) {

    }
}
