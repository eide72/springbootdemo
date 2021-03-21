package com.example.demo.exception.handle;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class
GlobalExceptionHandle {

    @ExceptionHandler(value = Throwable.class)
    public void handleException(Throwable ex){

//        String stackTraceMsg = ExceptionUtils.getStackTrace(ex);
        String stackTraceMsg = (ExceptionUtils.getRootCause(ex) != null) ?
                ExceptionUtils.getStackTrace(ExceptionUtils.getRootCause(ex)):ExceptionUtils.getStackTrace(ex);
        System.out.println(stackTraceMsg.length());
        String msg = ex.getMessage();
        System.out.println("******");
        System.out.println("异常被全局异常类捕获");
        System.out.println("xxxx"+stackTraceMsg+"xxxx");
        System.out.println("******");
        System.out.println(msg);
    }
}
