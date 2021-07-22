package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 23:00
 * Description:
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] data) {

    }

    /**
     * Time = O(n^2)
     * Space = O(1)
     * In-Place
     * Unstable
     */
    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            ArrayUtil.swap(data, i, min);
        }
    }
}
