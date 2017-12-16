package com.promotion.action.data.struct.tree;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 5, 7, 9, 45, 46, 59, 89, 92, 94, 100};
        System.out.println(a[find(a, a.length, 92)]);
    }
    /**
     * 二分查找元素下标
     * @param a    数组
     * @param high 右下标
     * @param key  关键字
     */
    public static int find(int[] a, int high, int key) {
        /*左下标*/
        int low = 1;
        while (low <= high) {
            /*折半*/
            int mid = (low + high) / 2;

            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}



