package com.example.demo.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Encoder;

@Data
@NoArgsConstructor
public class ResponseModel<T> {
    private String username;
    private String password;

    private T data;

}
