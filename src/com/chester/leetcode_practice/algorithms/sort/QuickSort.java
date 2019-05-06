package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 23:39
 * Description:
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] data) {

    }

    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int p = partition(data, low, high);
            quickSort(data, low, p - 1);
            quickSort(data, p + 1, high);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (data[j] < pivot) {
                ArrayUtil.swap(data, i, j);
                i++;
            }
        }
        ArrayUtil.swap(data, i, high);
        return i;
    }
}
