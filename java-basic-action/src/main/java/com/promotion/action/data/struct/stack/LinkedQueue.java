package com.promotion.action.data.struct.stack;

/**
 * Created by shifeifei on 2017/6/19.
 * 链式队列
 */
public class LinkedQueue<E> {

    //指向第一个结点
    transient Node<E> first;

    //指向最后一个结点
    transient Node<E> last;

    //队列元素个数
    private transient int count;

    /**
     * 链表结点
     *
     * @param <E>
     */
    static class Node<E> {
        E item;

        Node<E> next;

        Node(E x) {
            item = x;
        }
    }


}
