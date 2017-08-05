package com.promotion.action.data.struct.link.list;

/**
 * Created by shifeifei on 2017/6/9.
 * 循环单链表
 */
public class LoopSinglyLinkedList {

    //链表的长度
    private int size = 0;

    //定义头结点
    private Node<String> header;

    public LoopSinglyLinkedList() {
        //初始化一个空链表
        header = new Node<String>();
        header.next = header;
    }

    //定义链表节点
    private static class Node<E> {
        private E data;         //节点元素
        private Node<E> next;   //指向下一个节点元素指针

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * 表尾添加元素
     *
     * @param e
     */
    public void add(String e) {
        Node<String> node = new Node<String>(e);
        if (header.next == header) {
            //说明是空链表
            node.next = header;
            header.next = node;
            size++;
            return;
        }

        Node temp = header;
        while (header != temp.next) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = header; //表尾链接头结点
        size++;
    }

    /**
     * 指定位置添加元素
     *
     * @param e
     * @param index
     */
    public void add(String e, int index) {
        int j = 1; //记录下标位置

        if (header.next == header || index > size) {
            throw new RuntimeException("链表为空 || 插入位置不合法");
        }
        Node temp = header;
        while (header != header.next && j < index) {
            temp = temp.next;
            j++;
        }

        //找到插入点,开始插入
        Node<String> node = new Node<String>(e);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /**
     * 删除元素
     *
     * @param e
     */
    public void delete(String e) {
        if (header.next == header) {
            throw new RuntimeException("链表为空");
        }

        Node temp = header;
        while (header != temp.next) {
            Node tempNext = temp.next;
            if (null != tempNext.data && tempNext.data.equals(e)) {
                temp.next = tempNext.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
    }

    public void print() {
        if (header.next == header) {
            System.out.println("该链表是空链表");
        }

        Node temp = header;
        while (header != temp.next) {
            temp = temp.next;
            System.out.println("当前链表元素: " + temp.data);
        }
        System.out.println("链表当前长度: " + size + "\n");

    }

    public static void main(String[] args) {

        LoopSinglyLinkedList linkedList = new LoopSinglyLinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        linkedList.print();

        linkedList.add("f", 2);

        linkedList.print();

        linkedList.delete("d");

        linkedList.print();
    }
}
