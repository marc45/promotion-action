package com.promotion.action.data.struct.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] a = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        selectSort(a);
    }


    public static void selectSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {//做第i趟排序

            int k = i;

            for (int j = k + 1; j < a.length; j++) { //循环找最小的记录
                if (a[j] < a[k]) {
                    k = j;//记录的最小下标
                }
            }

            //内存循环结束后，找到本轮最小记录后交换
            if (k != i) {
                a[i] = a[i] ^ a[k];
                a[k] = a[k] ^ a[i];
                a[i] = a[i] ^ a[k];
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
