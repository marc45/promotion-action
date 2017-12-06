package com.promotion.action.data.struct.tree.binary.sort;

public class BTest {


    public static void main(String[] args) {

        BinarySortTree<Integer> bst = new BinarySortTree<Integer>();
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
        bst.insert(9);
        bst.insert(6);
        bst.insert(4);
        System.out.println(bst.printTree());


        System.out.println(bst.search(9).data);

    }

}
