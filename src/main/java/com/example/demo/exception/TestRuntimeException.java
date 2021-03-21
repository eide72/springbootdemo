package com.example.demo.exception;

public class TestRuntimeException extends RuntimeException {

    public TestRuntimeException() {};

    public TestRuntimeException(String msg) {
        super(msg);
    }

    public TestRuntimeException(Throwable t) {
        super(t);
    }

    public TestRuntimeException(String msg, Throwable t) {
        super(msg, t);
    }
}