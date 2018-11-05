package com.yilmazdenizcan.customer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@Controller
public class HomeController {
    /*
    * page direction controller
    */

    @GetMapping(value = "/customersapp")
    public String index(){
        return "index.html";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(){
        return "login.html";
    }



}
