package com.example.demo;

import com.example.demo.aspect.AutoLog;
import com.example.demo.exception.TestRuntimeException;
import com.example.demo.utils.Thread1;
import com.example.demo.utils.Thread2;
import com.example.demo.utils.ThreadTestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        String uuid = UUID.randomUUID().toString();
        List list = new ArrayList(1000);
        System.out.println(list.size());
        list.add("1");
        System.out.println(list.size());
//        try {
//            int a = 10/0;
//        } catch (Exception e) {
//            throw new RuntimeException("异常测试" + e.getMessage());
//        }
//        for(int i = 0; i < 10; i++){
//            ThreadTestUtils.count = 0;
//            Thread t1 = new Thread(new Thread1());
//            Thread t2 = new Thread(new Thread2());
//            try{
//                t1.start();
//                t2.start();
//                t1.join();
//                t2.join();
//            } catch(Exception e){
//
//            }
//            System.out.println(ThreadTestUtils.count);
//        }
    }

    @AutoLog(value = "编辑DEMO")
    @GetMapping("/demo")
    public String demo() throws Exception {
        int b = 10/0;
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new RuntimeException("异常测试" + e.getMessage());
        } finally {
            System.out.println("仍继续执行");
        }
        System.out.println("仍继续执行");
        return "Hello World!";
    }
}
