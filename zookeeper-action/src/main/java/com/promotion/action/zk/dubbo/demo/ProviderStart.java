package com.promotion.action.zk.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shifeifei on 2017/12/3.
 */
public class ProviderStart {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"/spring/dubbo-provider.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }
}
