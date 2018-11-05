package com.yilmazdenizcan.customer.controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.yilmazdenizcan.customer.controllers.UserController;
import com.yilmazdenizcan.customer.entities.User;
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
@WebMvcTest(UserController.class)
public class UserControllerTest {


    //to mock the User Controller layer code for our unit tests
    //by the way,it tests service methods also
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserController userController;

    // user creation function for other methods usage
    private User createUser(){
        Long id = Long.parseLong("10");
        User user = new User();
        user.setId(id);
        user.setUsername("Ali");
        user.setPassword("Veli");
        user.setActive(true);
        return user;
    }

    // it tests users() method in controller
    // check the right size of list and users name
    // and http response code
    @Test
    public void testAllUsers() throws Exception {
        User user = createUser();
        List<User> allusers = Collections.singletonList(user);

        given(userController.users()).willReturn(allusers);

        mvc.perform(get("/users").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username", is(user.getUsername())))
                .andDo(MockMvcResultHandlers.print());
    }

    // it tests addUser() method in controller
    // check the http response code
    @Test
    public void testAddUser() throws Exception {
        User user = createUser();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        mvc.perform(post("/add")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    // it tests validateUser(string username,string password) method in controller
    // check the http response code
    @Test
    public void testValidateUser() throws Exception{
        String username = "aaaaaaaaaa";
        String password = "bbbbbbbbbbb";

        mvc.perform(post("/validateuser/{username}/{password}",username,password)
                .accept(MediaType.APPLICATION_JSON).contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    // it tests deleteAllUser() method in controller
    // check the http response code
    @Test
    public void testDeleteAllUsers() throws Exception {
        mvc.perform(post("/deleteallusers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
