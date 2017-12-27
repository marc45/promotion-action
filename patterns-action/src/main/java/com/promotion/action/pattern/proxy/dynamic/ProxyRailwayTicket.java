package com.promotion.action.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyRailwayTicket implements InvocationHandler {

    //保存真实业务对象
    private Object target;

    /**
     * 返回动态代理对象，利用代理对象去操作真实对象
     *
     * @param obj
     * @return
     */
    public Object getProxy(Object obj) {
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);//通过反射调用真实业务对象方法，并返回
    }
}
