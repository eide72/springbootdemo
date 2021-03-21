package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {

    public void test(){
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new RuntimeException("异常测试" + e.getMessage());
        }
    }
}
