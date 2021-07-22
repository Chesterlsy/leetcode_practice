package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 22:24
 * Description:
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T>  {
    @Override
    public void sort(T[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) { // i numbers has sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    ArrayUtil.swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * Time = O(n^2)
     * Space = O(1)
     * In-Place
     * Stable
     */
    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) { // i numbers has sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    ArrayUtil.swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * Time average = O(n^2)
     * Time worst = O(n^2) when reversely sorted
     * Time best = O(n) when already sorted
     * Space = O(1)
     * In-Place
     * Stable
     */
    public static void optimizedSort(int[] data) {
        int n = data.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) { // i numbers has sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    ArrayUtil.swap(data, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
