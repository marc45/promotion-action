package com.promotion.action.data.struct.stack;

/**
 * Created by shifeifei on 2017/6/11.
 */
public class MyLinkedStack<T> {

    private Node<T> top;

    private int size;

    public void MyLinkedStack() {
    }

    private static class Node<T> {
        private T element;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    //入栈
    public void push(T e) {
        top = new Node<T>(e, top);
        size++;
    }

    //出栈
    public void pop() {
        if (size == 0) {
            throw new RuntimeException("空栈");
        }

        Node old = top;
        top = top.next;
        //释放引用
        old.next = null;
        size--;
    }

    public String print() {
        StringBuffer sb = new StringBuffer();
        Node temp = top;
        while (null != temp) {
            sb.append(temp.element).append("\t");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedStack<String> linkedStack = new MyLinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");
        linkedStack.push("d");

        System.out.println(linkedStack.print());
        System.out.println("---------------");

        linkedStack.pop();
        System.out.println(linkedStack.print());
    }
}
