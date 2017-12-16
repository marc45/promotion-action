package com.promotion.action.zk.dubbo.demo.provider;

/**
 * Created by shifeifei on 2017/12/3.
 */
public class DemoServiceImpl implements DemoService{
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
