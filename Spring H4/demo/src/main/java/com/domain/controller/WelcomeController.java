package com.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    @GetMapping // akan menghendel request get yang datang
    public String welcome(){
        return "Welcome to Spring Boot Rest API";
    }//fungsion atau method


}
