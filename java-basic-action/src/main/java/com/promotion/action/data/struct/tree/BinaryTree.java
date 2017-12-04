package com.promotion.action.data.struct.tree;


/**
 * 二叉树的二叉链表表示法
 */
public class BinaryTree {

    public static class BinaryNode<T extends Comparable> {
        T data;
        /*左孩子指针域*/
        BinaryNode<T> lchild;
        /*右孩子指针域*/
        BinaryNode<T> rchild;

        public BinaryNode(T data) {
            this(data, null, null);
        }

        public BinaryNode(T data, BinaryNode<T> lchild, BinaryNode<T> rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }
}



