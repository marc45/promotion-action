package com.promotion.action.pattern.adapter.obj;

import java.util.Arrays;

/**
 * 适配者：快速排序类
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {89, 52, 4, 63, 4, 78};

        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSort(a)));
    }


    /**
     * 在区间R[low..high]中任选一个记录作为基准(Pivot)，以此基准将当前无序区划分为
     * 左、右两个较小的子区间 R[low..pivotpos-1)和 R[pivotpos+1..high]，
     * 并使左边子区间中所有记录的关键字均小于等于基准记录，右边的子区间中所有记录关键字均大于等于基准记录，
     * 而基准记录 pivot 则位于正确的位置(pivotpos)上，它无须参加后续的排序。
     * <p>
     * 通过递归调用快速排序对左、右子区间 R[low..pivotpos-1]和R[pivotpos+1..high]快速排序
     */
    public int[] quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public void sort(int[] array, int low, int high) {
        int q = 0;
        if (low < high) {
            q = partition(array, low, high);
            sort(array, low, q - 1);
            sort(array, q + 1, high);
        }
    }

    /**
     * 划分算法
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] a, int low, int high) {
        int x = a[high];
        int j = low - 1;
        //遍历右区间
        for (int i = low; i <= high - 1; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, j + 1, high);
        return j + 1;
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
