package com.promotion.action.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象；动态代理不需要实现接口，但需要指定接口类型
 * 匿名内部类实现 ： InvocationHandler接口
 */
public class ProxyFactory {

    //保存真实对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //生成代理对象
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



