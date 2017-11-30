package com.yuan.web;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuan.dubbo.IDubboService;

public class ConsumerTest {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "dubbo-consumer.xml" });  
        context.start();  
  
        IDubboService dubboService = (IDubboService) context.getBean("dubboService"); //  
        String hello = dubboService.sayHello("tom"); // ִ  
        System.out.println(hello); //   
  
        //   
        List list = dubboService.getUsers();  
        if (list != null && list.size() > 0) {  
            for (int i = 0; i < list.size(); i++) {  
                System.out.println(list.get(i));  
            }  
        }  
        System.in.read();  
    }  
}
