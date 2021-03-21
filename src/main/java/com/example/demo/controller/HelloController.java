package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public void test(){
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
