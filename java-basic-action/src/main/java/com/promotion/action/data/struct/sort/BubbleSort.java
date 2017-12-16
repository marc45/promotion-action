package com.promotion.action.data.struct.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        bubbleSort(a);
    }

    public static void bubbleSort(int[] a) {
        boolean flag = true;
        for (int i = 1; i < a.length && flag; i++) {

            flag = false;

            for (int j = a.length - 1; j >= i; j--) {

                if (a[j - 1] > a[j]) {

                    a[j - 1] = a[j - 1] ^ a[j];
                    a[j] = a[j] ^ a[j - 1];
                    a[j - 1] = a[j - 1] ^ a[j];
                    /*如果相邻元素有交互,则flag置为true*/
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}


