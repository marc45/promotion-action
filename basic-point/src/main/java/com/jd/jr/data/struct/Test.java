package com.jd.jr.data.struct;

import java.util.ArrayDeque;

/**
 * Created by shifeifei on 2017/6/2.
 */
public class Test {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<String>(5);

        arrayDeque.add("a");
        arrayDeque.add("b");
        arrayDeque.add("c");
        arrayDeque.add("e");
        arrayDeque.add("f");
        arrayDeque.add("g");

        System.out.println(arrayDeque);

        arrayDeque.pop();

        System.out.print(arrayDeque);


    }
}
