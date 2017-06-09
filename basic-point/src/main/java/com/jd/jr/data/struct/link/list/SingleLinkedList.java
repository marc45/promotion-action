package com.jd.jr.data.struct.link.list;

/**
 * Created by shifeifei on 2017/6/5.
 * 线性表之单链表
 */
public class SingleLinkedList {

    //链表的长度
    private int size = 0;

    //定义头结点
    private Node<String> header;

    //单链表的第一个元素
    private Node<String> first;

    public SingleLinkedList() {
        //初始化头结点
        header = new Node<String>();
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
     * 单链表表尾添加元素
     *
     * @param e
     */
    public void add(String e) {
        Node<String> node = new Node<String>(e);

        if (null == first) {
            first = node;
            //头结点指向链表第一个节点
            header.next = first;
            size++;
            return;
        }

        Node<String> temp = first;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /**
     * 单链表指定位置添加元素
     *
     * @param e
     * @param index
     */
    public void add(String e, int index) {
        int j = 1;
        Node temp = header;

        if (null == temp.next || index > size) {
            throw new RuntimeException("链表为空||插入位置不合法");
        }

        while (null != temp.next && j < index) {
            //继续寻找插入点
            temp = temp.next;
            j++;
        }
        //找到插入点,开始插入元素
        Node tempNode = new Node(e);

        tempNode.next = temp.next;
        temp.next = tempNode;
        size++;
    }

    /**
     * 单链表删除元素
     *
     * @param e
     */
    public void delete(String e) {
        Node temp = header;
        while (null != temp.next) {
            Node tempNext = temp.next;
            if (null != tempNext.data && tempNext.data.equals(e)) {
                temp.next = tempNext.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * 单链表元素遍历
     */
    public void print() {
        Node temp = header;
        while (null != temp.next) {
            temp = temp.next;
            System.out.println("当前节点元素: " + temp.data);
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.add("a");
        list.add("b");
        list.add("e");
        list.add("f");

        list.print();

        System.out.println("-----------------------");

        list.add("g", 2);
        list.print();
        System.out.println("链表长度: " + list.size);


        System.out.println("-----------------------");
        list.delete("a");
        list.print();

    }
}
