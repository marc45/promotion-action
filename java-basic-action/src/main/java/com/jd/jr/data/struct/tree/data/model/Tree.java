package com.jd.jr.data.struct.tree.data.model;

/**
 * Created by shifeifei on 2017/7/5.
 */
public class Tree {

    Node[] elements;

    /*根节点位置,由于根节点没有双亲,约定其位置-1*/
    int rootIndex;

    /*元素个数*/
    int size;

    static class Node {
        /*结点数据*/
        Object data;

        /*双亲位置*/
        int parent;
    }
}
