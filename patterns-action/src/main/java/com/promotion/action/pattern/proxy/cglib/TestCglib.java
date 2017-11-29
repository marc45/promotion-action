package com.promotion.action.pattern.proxy.cglib;

public class TestCglib {

    public static void main(String[] args) {
        //目标对象
        UserDao dao = new UserDao();
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(dao).getProxy();
        proxy.save();

    }

}
