package com.promotion.action.generic;


import java.util.ArrayList;
import java.util.List;

/**
 * 原生类型：新生代码中不要使用原生类型；每个泛型都会定一个原生类型；
 */
public class RawType {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<String>();
        add(stringList, new Integer(9));
        System.out.println(stringList.get(0)); //java.lang.ClassCastException
    }


    public static void add(List list, Object o) {
        list.add(o);
    }

}
