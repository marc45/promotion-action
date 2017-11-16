package com.promotion.action.generic;

import java.util.Arrays;

/**
 * 如何处理泛型和数组混用出现的编译问题
 */
public class GenericTest {

    public static void main(String[] args) {
    }
}

class Stack<E> {

    private Object[] elements;
    private Integer size = 0;

    private static final Integer DEFAULT_INIT_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INIT_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() throws Exception {
        if (size == 0) throw new Exception("栈空");
        E result = (E) elements[--size];
        elements[size++] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
