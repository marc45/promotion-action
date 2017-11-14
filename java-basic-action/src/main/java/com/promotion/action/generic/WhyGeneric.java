package com.promotion.action.generic;

import java.util.ArrayList;
import java.util.List;


/**
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数
 * <p>
 * 作用：（可读性和安全性）编译时进行类型安全检查；提高代码复用率以及可读性；
 */
public class WhyGeneric {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("aaa");
        list.add(1);

        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i);
            System.out.println("------------" + name);
        }

    }

}
