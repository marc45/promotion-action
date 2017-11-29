package com.promotion.action.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象
 * 匿名内部类实现 ： InvocationHandler接口
 * 学习博客：https://www.cnblogs.com/cenyu/p/6289209.html
 */
public class ProxyFactory {

    //保存真实对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {

        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        return method.invoke(target, args);
                    }

                });
        return proxy;
    }

}
