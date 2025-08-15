package com.example.springboot_mysql_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Representation state transfer
// Restfull API
// Get api/customers -> returns all customers
// Get api/customers/id -> returns customers with ID = id
// GET / POST/ PUT / DELETE / PATCH


@RestController
public class PingPong {

    @GetMapping("/")
    public String homepage(){
        return "Welcome";
    }

    @GetMapping("/ping")
    public String ping()
    {
        return "pong";
    }
}
