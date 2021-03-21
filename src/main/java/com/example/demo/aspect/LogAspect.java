/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    public final String POINT_CUT1 = "execution(* com..service.impl..*.*(..))";
    public final String POINT_CUT2 = "execution(* com..controller..*.*(..))";

//    @Pointcut("execution(* com..service.impl..*.*(..))")
    @Pointcut("execution(* com..controller..*.*(..))")
//    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RestController)")
    public void myPointcut(){

    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
//    @AfterThrowing(value="execution(* com.example.demo.DemoApplication.*(..))", throwing = "e")
//    @AfterThrowing(value = "@annotation(org.springframework.web.bind.annotation.RestController)", throwing = "e")
    @AfterThrowing(pointcut = "myPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        String methodNames = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Map<String, Object> map = new HashMap<>();
        try{
            String a = null;
            boolean flag = a.equals("1111");
        }catch (Exception ex){
            System.out.println("***********");
            System.out.println("aop发生异常"+ex.getMessage());
        }
        System.out.println("***********");
        System.out.println(methodNames);
        System.out.println("异常被AOP捕获");
        System.out.println("---------");
        System.out.println(e.getMessage());
    }

//    @Before("myPointcut()")
////    @Before(value="execution(* com.example.demo.controller.*.*(..))")
//    public void methodBefore(JoinPoint joinPoint){
//        System.out.println("********");
//        System.out.println("方法执行前进入aop");
//    }
//

    @Around("myPointcut()")
    public Object methodAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("********");
        System.out.println("方法around进入aop");
        Object result = joinPoint.proceed();
        return result;
    }
}
