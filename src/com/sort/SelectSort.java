package com.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    @Test
    public void test() {
        int[] arr = new int[]{19, 3, 1, 30, 15};
        System.out.println(Arrays.toString(selectSort(arr)));
    }

    /**
     * 从后面找到最小的，排到未排序的索引
     */
    public int[] selectSort(int[] arr) {
        int temp, min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
