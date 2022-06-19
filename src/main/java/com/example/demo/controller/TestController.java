package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.aspect.AutoLog;
import com.example.demo.dao.entity.TestEntity;
import com.example.demo.exception.TestRuntimeException;
import com.example.demo.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;
    @Autowired
    private HelloController helloController;

    @AutoLog(value = "编辑DEMO")
    @GetMapping("/demo")
    public String demo() throws Exception {
        System.out.println("进入controller");
//        try {
//            test();
//        } catch (Exception e) {
//            throw new RuntimeException("异常测试" + e.getMessage());
//        } finally {
//            System.out.println("仍继续执行");
//        }
//        int i=1/0;
//        helloController.test();
        test();
        System.out.println("跳出catch");
        return "Hello World!";
    }

    @GetMapping("/demo1")
    public String demo1() {
        System.out.println("进入controller");
        testServiceImpl.test();
        return "Hello World!";
    }

    @GetMapping("/demo2")
    public String demo2() {
//        try{
//            int a = 10/0;
//        }catch(Exception e){
//            throw new TestRuntimeException("demo2" + e.getMessage());
//        }
        int a = 10 / 0;
        return "Hello World";
    }

    @GetMapping("/demo3")
    public String demo3() {
        TestEntity entity = new TestEntity();
        TestEntity entity2 = new TestEntity();
        String tmpStr = "9999999";
        System.out.println(JSONObject.toJSONString(entity));
        TestRuntimeException testRuntimeException = new TestRuntimeException("异常测试");
        String str = multyParams(testRuntimeException, "demo3", entity, entity2);
        System.out.println(str);
        return str;
    }

    public void test() {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            throw new TestRuntimeException(e);
        }
    }

    public String multyParams(TestRuntimeException ex, String MethodName, Object... inputParams) {
        String resStr = "";
        System.out.println(ex.getMessage());
        for (Object param : inputParams) {
            resStr += JSONObject.toJSONString(param) + ",";
        }
        return resStr.substring(0, resStr.length()-1);
    }
}

