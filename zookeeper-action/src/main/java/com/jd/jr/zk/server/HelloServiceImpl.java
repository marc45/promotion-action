package com.jd.jr.zk.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    public HelloServiceImpl() throws RemoteException{}

    public String sayHello(String name) throws RemoteException{
        return String.format("Hello %s",name);
    }
}
