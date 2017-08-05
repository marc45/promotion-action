package com.jd.jr.zk.client;

import com.jd.jr.zk.server.HelloService;

import java.rmi.Naming;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class RimClient {

    public static void main(String[] args) throws Exception {

        String url = "rmi://localhost:1098/com.jd.jr.zk.server.HelloServiceImpl";

        HelloService helloService = (HelloService) Naming.lookup(url);

        String result = helloService.sayHello("shifeifei");

        System.out.println(result);

    }

}
