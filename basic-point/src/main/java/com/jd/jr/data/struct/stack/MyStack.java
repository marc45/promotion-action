package com.jd.jr.data.struct.stack;

import java.util.Arrays;

/**
 * Created by shifeifei on 2017/6/11.
 */
public class MyStack<T> {

    protected Object[] elementData;

    public MyStack() {
        elementData = new Object[]{};
    }

    /**
     * 入栈
     *
     * @param e
     * @return
     */
    public T push(T e) {
        int len = capacity();
        elementData[len - 1] = e;
        return e;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        int len = size();
        if (len == 0) {
            throw new RuntimeException("空栈");
        }
        //删除栈顶元素
        int index = len - 1;
        if (index < 0) {
            throw new RuntimeException("空栈");
        }
        T e = (T) elementData[index];

        Object[] newElements = new Object[index];
        for (int i = 0; i < index; i++) {
            newElements[i] = elementData[i];
        }
        elementData = newElements;
        return e;
    }

    public int size() {
        return elementData.length;
    }

    private int capacity() {
        elementData = Arrays.copyOf(elementData, elementData.length + 1);
        return elementData.length;
    }

    public void print() {
        for (Object o : elementData) {
            System.out.print(o + "\n");
        }
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("f");

        stack.print();
        System.out.println("--------");
        stack.pop();

        stack.print();

        stack.pop();
        System.out.println("--------");
        stack.print();
    }
}
