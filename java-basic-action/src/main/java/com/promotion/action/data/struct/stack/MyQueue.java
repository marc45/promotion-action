package com.promotion.action.data.struct.stack;

import java.util.Arrays;

/**
 * Created by shifeifei on 2017/6/15.
 * 队列的线性实现
 */
public class MyQueue<T> {

    //存储队列元素
    T[] elements;

    //指向队头
    private int head;

    //指向队尾
    private int tail;

    public MyQueue() {
        elements = (T[]) new Object[5];
        tail = head = 0;
    }

    /**
     * 入队,队尾添加元素
     *
     * @param e
     */
    public void addLast(T e) {
        if (e == null)
            throw new RuntimeException("插入元素不能为空");
        elements[tail] = e;
        //指向队列尾部
        tail = (tail + 1) % elements.length;
        //判断队列是否满了,满了则动态扩容
        if (tail == head)
            allocateSpace();
    }

    /**
     * 出队,队头删除元素
     *
     * @param e
     */
    public Object removeFirst(T e) {
        if (e == null)
            throw new RuntimeException("插入元素不能为空");

        Object temp = elements[head];
        elements[head] = null;

        //向后移动队头下标
        head = (head + 1) % elements.length;
        return temp;
    }

    /**
     * 动态扩容
     */
    public void allocateSpace() {
        int p = head;
        int size = elements.length;
        //队列数组右侧的元素个数
        int r = size - p;
        int newCapacity = size << 1;// size值的二进制数的最后一位上加个0
        if (newCapacity < 0)
            throw new RuntimeException("队列扩容出错");

        Object[] a = new Object[newCapacity];
        //复制head下标右侧元素：即从elements数组的head开始r长度元素复制到a数组0位置开始
        System.arraycopy(elements, p, a, 0, r);
        //复制head下标左侧元素：即从elements数组的0开始p长度元素复制到a数组r位置开始
        System.arraycopy(elements, 0, a, r, p);

        elements = (T[]) a;
        head = 0;
        tail = size; //指向队尾
    }

    /**
     * 队列长度
     *
     * @return
     */
    public int size() {
        return (tail - head + elements.length) % elements.length;
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<String>();
        myQueue.addLast("a");
        myQueue.addLast("b");
        myQueue.addLast("c");
        myQueue.addLast("d");
        myQueue.addLast("f");
        myQueue.addLast("g");
        myQueue.addLast("h");
        myQueue.addLast("i");

        System.out.println(Arrays.toString(myQueue.elements) + ",size=" + myQueue.size());

        System.out.println(myQueue.removeFirst("a"));

        System.out.println(Arrays.toString(myQueue.elements) + ",size=" + myQueue.size());
    }

}
