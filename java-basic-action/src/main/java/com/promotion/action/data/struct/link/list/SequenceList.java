package com.promotion.action.data.struct.link.list;

import java.util.Arrays;

/**
 * Created by shifeifei on 2017/6/4.
 * 顺序线性表的实现
 */
public class SequenceList {

    //线性表最大存储空间
    private static final Integer MAX_SIZE = 20;

    //默认分配空间
    private static final Integer DEFAULT_SIZE = 10;

    //线性表存储元素个数
    private Integer size;

    //存储线性表的元素
    private Object[] data;

    private Object[] DEFAULT_DATA = {};

    private SequenceList() {
        this.data = DEFAULT_DATA;
        this.size = 0;
    }

    private SequenceList(int size) {
        if (size > MAX_SIZE || size < 0)
            this.data = new Object[DEFAULT_SIZE];
        else
            this.data = new Object[size];
        this.size = data.length;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    private Object get(int index) {
        if (index > MAX_SIZE || index <= 0) {
            throw new RuntimeException("参数不合法");
        }
        return data[index];
    }

    /**
     * 线性表尾部添加元素
     *
     * @param o
     */
    private void add(Object o) {
        if (data.length > MAX_SIZE) {
            throw new RuntimeException("线性表空间已经满了");
        }

        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = o;
        size++;
    }


    private void add(Object o, int index) {
        if (index > MAX_SIZE) {
            throw new RuntimeException("线性表空间已经满了");
        }

        //原数组扩容一个长度
        data = Arrays.copyOf(data, data.length + 1);
        //复制数组元素: 相当于从srcPos开始的length长度元素复制到desPos位置开始
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = o;

        size++;
    }

    public static void main(String[] args) {

        SequenceList list = new SequenceList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        for (int i = 0; i < list.data.length; i++) {
            System.out.println(list.data[i]);
        }
        System.out.println("线性表元素个数：" + list.size);

        System.out.println("get result : " + list.get(2));


        list.add("g", 1);


        for (int i = 0; i < list.data.length; i++) {
            System.out.println(list.data[i]);
        }
    }
}
