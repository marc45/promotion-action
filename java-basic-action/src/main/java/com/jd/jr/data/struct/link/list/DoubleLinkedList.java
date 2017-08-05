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
        private Node<T> prior;  //前驱结点
        private Node<T> next;   //后继结点

        public Node(T element, Node<T> prior, Node<T> next) {
            this.element = element;
            this.prior = prior;
            this.next = next;
        }
    }

    public DoubleLinkedList() {
        //初始化一个空链表,前驱和后驱都指向自己
        header.next = header.prior = header;
    }

    /**
     * 链表末尾添加元素
     *
     * @param e
     */
    public void add(T e) {
        //创建一个新结点,设置它的前驱是原链表尾结点,后继是头节点
        Node<T> node = new Node<T>(e, header.prior, header);

        //设置该新结点的后驱结点(就是头结点header)的前驱
        node.next.prior = node;

        //设置该新结点的前驱结点(就是原链表尾结点)的后驱
        node.prior.next = node;
        size++;
    }

    /**
     * 删除结点元素
     */
    public void delete(T e) {
        Node<T> node = new Node<T>(e, null, null);
        //遍历查找结点
        for (Node<T> temp = header.next; temp != header; temp = temp.next) {
            if (temp.element.equals(node.element)) {
                temp.prior.next = temp.next;
                temp.next.prior = temp.prior;

                size--;
            }
        }
    }

    public void print() {
        if (size < 1) {
            throw new RuntimeException("空链表");
        }
        for (Node<T> temp = header.next; temp != header; temp = temp.next) {
            System.out.println("元素结点: " + temp.element);
        }
    }

    public static void main(String[] args) {

        DoubleLinkedList<String> linkedList = new DoubleLinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        linkedList.print();

        linkedList.delete("b");
        System.out.println("------------------------------");

        linkedList.print();
    }

}
