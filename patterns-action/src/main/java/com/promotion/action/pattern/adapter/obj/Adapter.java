package com.promotion.action.pattern.adapter.obj;

public class Adapter implements Score {

    private QuickSort quickSort;

    private BinarySearch binarySearch;


    public Adapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    public int[] sort(int[] scores) {
        return quickSort.quickSort(scores);
    }

    public int search(int[] scores, int key) {
        return binarySearch.find(scores, scores.length, key);
    }


}
