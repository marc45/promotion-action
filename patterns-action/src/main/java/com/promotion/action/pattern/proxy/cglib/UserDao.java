package com.promotion.action.pattern.proxy.cglib;

/**
 * 真实目标对象，没有实现任何接口
 */
public class UserDao {
    public void save() {
        System.out.println("-----------数据已保存------------");
    }
}
