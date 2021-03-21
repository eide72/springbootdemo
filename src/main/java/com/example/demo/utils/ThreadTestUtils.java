package com.example.demo.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.ArrayList;
import java.util.List;

public class ThreadTestUtils {
    public static Integer count = 0;
    public static List<Integer> list = new ArrayList<>();

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Thread t1 = new Thread(new Thread1());
//        Thread t2 = new Thread(new Thread2());
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(ThreadTestUtils.count);
//    }
}
