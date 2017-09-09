package com.promotion.action.data.struct.tree.data.model;

/**
 * 树的孩子表示法
 */
public class CTree {

    private Integer maxSize = 100;

    /*存储所有树结点*/
    private Node[] data;
    /*树的结点个数*/
    private int size;


    /*表头结点*/
    private static class Node<T> {
        T data;
        ChildNode firstChild;
    }

    /*孩子结点链表*/
    private static class ChildNode {

        int child; //孩子结点下标
        ChildNode next;  //指向下一个孩子结点

    }

}
