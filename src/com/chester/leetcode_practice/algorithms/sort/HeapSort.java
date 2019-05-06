package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 00:31
 * Description:
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] data) {

    }

    @Override
    public void sort(int[] data) {
        int n = data.length;

        for (int i = parent(n - 1); i >= 0; i--) {
            heapify(data, n, i);
        }

        for (int j = n - 1; j >= 1; j--) {
            ArrayUtil.swap(data, 0, j);
            heapify(data, j, 0);
        }
    }

    private static void heapify(int[] data, int n, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < n && data[left] > data[largest]) {
            largest = left;
        }
        if (right < n && data[right] > data[largest]) {
            largest = right;
        }
        if (largest != i) {
            ArrayUtil.swap(data, i, largest);
            heapify(data, n, largest);
        }

    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }
}
