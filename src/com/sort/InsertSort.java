package com.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    @Test
    public void test() {
        int[] arr = new int[]{20, 1, 9, 4, 2, 10};
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int pos = i;
            while (pos > 0 && arr[pos - 1] > value) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = value;
        }
        return arr;
    }
}
