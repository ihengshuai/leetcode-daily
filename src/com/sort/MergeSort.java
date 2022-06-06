package com.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    @Test
    public void test() {
        int[] arr = new int[]{3, 1, 9, 18, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1);
        return arr;
    }

    public static void internalMergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(arr, temp, left, middle);
            internalMergeSort(arr, temp, middle + 1, right);
            mergeSortedArr(arr, temp, left, middle, right);
        }
    }

    public static void mergeSortedArr(int[] arr, int[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < k; ++i) {
            arr[left + i] = temp[i];
        }
    }
}
