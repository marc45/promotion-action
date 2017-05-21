package com.jd.jr.zk.server;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class RimServer {

    public static void main(String[] args) throws Exception {
        int port = 1098;
        String url = "rmi://localhost:1098/com.jd.jr.zk.server.HelloServiceImpl";

        LocateRegistry.createRegistry(port);
        Naming.bind(url,new HelloServiceImpl());
    }

}
