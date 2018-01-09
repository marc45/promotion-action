package com.promotion.action.pattern.adapter.obj;

/**
 * 目标接口
 */
public interface Score {
    //成绩排序
    int[] sort(int scores[]);

    //成绩查找
    int search(int scores[], int key);
}
