package com.promotion.action.zk;

import com.promotion.action.zk.server.HelloService;
import com.promotion.action.zk.server.HelloServiceImpl;
import com.promotion.action.zk.server.ZKProvider;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class ZKTest {

    public static void main(String[] args) throws Exception {

        String host = "10.13.24.4";
        int port = 11237;

        ZKProvider provider = new ZKProvider();

        HelloService helloService = new HelloServiceImpl();

        provider.publish(helloService, host, port);

        Thread.sleep(Long.MAX_VALUE);

    }

}
