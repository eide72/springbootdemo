package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.aspect.AutoLog;
import com.example.demo.dao.entity.ResponseModel;
import com.example.demo.dao.entity.TestEntity;
import com.example.demo.exception.TestRuntimeException;
import com.example.demo.utils.Thread1;
import com.example.demo.utils.Thread2;
import com.example.demo.utils.ThreadTestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        test();
        String test = "";
        int a = test.length();
        String tepm = test.toLowerCase();
        SpringApplication.run(DemoApplication.class, args);
        ungzipFile();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);
        TestEntity entity = new TestEntity();
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
        try {
            int a = 10/1;
        } catch (Exception e) {
            throw new RuntimeException("异常测试" + e.getMessage());
        } finally {
            System.out.println("*********");
            System.out.println("仍继续执行");
        }
        return "Hello World!";
    }

    public static void ungzipFile(){
        File srcFile = new File("D:\\Code\\IDEAProjects\\springbootdemo\\test.txt.gz");
        File desFile = new File("D:\\Code\\IDEAProjects\\springbootdemo\\eide");
        FileInputStream is;
        FileOutputStream os;
        InputStream gzis;
        final int MAX_BYTE = 1024*1000;
        int len = 0;
        byte [] b = new byte[MAX_BYTE];
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(desFile);
            try {
                gzis = new GZIPInputStream(is);
                try{

                }catch(Exception e){

                }
                byte[] buffer = gzis.readAllBytes();
                while((len = gzis.read(b))!=-1){
                    os.write(b,0,len);
                }
                os.flush();
                gzis.close();
                os.close();
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test(){
        ResponseModel res = new ResponseModel();
        TestEntity entity = new TestEntity();
        entity.setName("eide");
        entity.setPassword("123456");
        res.setData(entity);
        res.setUsername("eide");
        res.setPassword("123456");
//        res.setData(JSON.toJSONString(entity));
        res.setData(entity);
        String jsonStr = JSON.toJSONString(res);
        System.out.println(jsonStr);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String data = jsonObject.getString("data");
        JSONObject respData = JSONObject.parseObject(data);
//        ResponseModel tmpModel = JSONObject.parseObject(jsonStr, ResponseModel.class);
//        JSONObject data = (JSONObject)tmpModel.getData();
//        String username = data.getString("name");
        return;

    }

    public void bubbleSort(int arr[], int len){
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int partition(int arr[], int low, int high){
        int key = arr[low];
        while(low < high){
            while(low < high && arr[high] >= key){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    public void quickSort(int arr[], int low, int high){
        if(low < high){
            int privot = partition(arr, low, high);

        }
    }

//    public int binarySearch(int[] arr, int key){
//        if(key < ar)
//    }
}
