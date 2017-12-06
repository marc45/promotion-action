package com.promotion.action.data.struct.tree.binary.sort;

//二叉链表实现二叉查找树
public class BinarySortTree<T extends Comparable<T>> {
    //定义根结点
    private BinarySortNode<T> root;

    public BinarySortNode<T> insert(T element) {
        if (null == element) return null;
        root = insert(element, root);
        return root;
    }

    private BinarySortNode<T> insert(T element, BinarySortNode<T> t) {
        if (null == t) {
            t = new BinarySortNode(element);
            t.lchild = t.rchild = null;
            t.data = element;
            return t;
        }
        //result<0 : element的值小于根节点
        int result = element.compareTo(t.data);
        if (result < 0) {
            t.lchild = insert(element, t.lchild);
        } else {
            t.rchild = insert(element, t.rchild);
        }
        return t;
    }


    public BinarySortNode<T> search(T data) {
        return search(root, data);
    }
    private BinarySortNode<T> search(BinarySortNode<T> t, T data) {
        if (null == root) {
            return null;
        }
        int result = data.compareTo(t.data);
        if (0 == result) {
            return t;
        } else if (result < 0) {
            //递归左子树
            return search(t.lchild, data);
        } else {
            return search(t.rchild, data);
        }
    }


    public String printTree() {
        return postOrder(root);
    }

    //中根遍历
    private String postOrder(BinarySortNode<T> t) {
        StringBuffer buffer = new StringBuffer();
        if (t != null) {
            buffer.append(postOrder(t.lchild));
            buffer.append(postOrder(t.rchild));
            buffer.append(t.data).append(",");
        }
        return buffer.toString();
    }

    //中根遍历
    private String inOrder(BinarySortNode<T> t) {
        StringBuffer buffer = new StringBuffer();
        if (t != null) {
            buffer.append(inOrder(t.lchild));
            buffer.append(t.data).append(",");
            buffer.append(inOrder(t.rchild));
        }
        return buffer.toString();
    }

    //前序遍历
    public String preOrder(BinarySortNode<T> t) {
        StringBuffer buffer = new StringBuffer();
        if (null != t) {
            buffer.append(t.data).append(",");
            //左子树
            buffer.append(preOrder(t.lchild));
            //右子树
            buffer.append(preOrder(t.rchild));
        }
        return buffer.toString();
    }

    //静态内部类定义结构
    public static class BinarySortNode<T> {
        T data;
        private BinarySortNode<T> lchild;
        private BinarySortNode<T> rchild;

        public BinarySortNode(T data) {
            this(data, null, null);
        }

        public BinarySortNode(T data, BinarySortNode<T> lchild, BinarySortNode<T> rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }
}








