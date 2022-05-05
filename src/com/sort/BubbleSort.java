package com.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    @Test
    public void test() {
        int[] sort = bubbleSort(new int[]{3, 1, 5, 2, 0, 5, 4});
        System.out.println(Arrays.toString(sort));
    }

    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
