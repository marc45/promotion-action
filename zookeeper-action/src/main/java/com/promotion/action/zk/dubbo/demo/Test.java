package com.promotion.action.zk.dubbo.demo;

import com.promotion.action.zk.dubbo.demo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shifeifei on 2017/12/3.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"/spring/dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // obtain proxy object for remote invocation
        String hello = demoService.sayHello("-------------------------------->world"); // execute remote invocation
        System.out.println(hello); // show the result
    }

}
