package com.example.demo.utils;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
//            synchronized (ThreadTestUtils.list){
//                ThreadTestUtils.count++;
//            }
            ThreadTestUtils.count++;
        }
    }
}
