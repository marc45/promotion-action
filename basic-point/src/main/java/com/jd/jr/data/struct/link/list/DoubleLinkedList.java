package com.jd.jr.data.struct.link.list;

/**
 * Created by shifeifei on 2017/6/9.
 * 双向链表
 */
public class DoubleLinkedList<T> {

    //链表的长度
    private int size;

    //头结点
    private Node<T> header = new Node<T>(null, null, null);

    /**
     * 链表结点
     */
    private static class Node<T> {
        T element;
        private Node<T> prior;
        private Node<T> next;

        public Node(T element, Node<T> prior, Node<T> next) {
            this.element = element;
            this.prior = prior;
            this.next = next;
        }
    }

    public DoubleLinkedList() {
        //初始化一个空链表
        header = header.next = header.prior;
    }

    /**
     * 链表末尾添加元素
     *
     * @param e
     */
    public void add(T e) {

    }

}
