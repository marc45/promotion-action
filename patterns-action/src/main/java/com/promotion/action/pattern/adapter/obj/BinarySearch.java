package com.promotion.action.pattern.adapter.obj;

/**
 * 二分查找表必须是有序的
 */
public class BinarySearch {

    public int find(int[] a, int high, int key) {
        int low = 1;

        while (low <= high) {
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
