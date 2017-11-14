package com.promotion.action.data.struct.tree;


/**
 * 二叉树
 */
public class BinaryTree {


    public void createdTree() {


    }


    /**
     * 二叉树的二叉链表表示法
     *
     * @param <T>
     */
    public static class TreeNode<T> {

        T data;

        /*左孩子指针域*/
        TreeNode<T> left;

        /*右孩子指针域*/
        TreeNode<T> right;
    }


}
