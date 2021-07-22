package com.chester.leetcode_practice.algorithms.sort;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 23:09
 * Description:
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T>  {
    @Override
    public void sort(T[] data) {

    }

    /**
     * Time average = O(n^2)
     * Time worst = O(n^2) when reversely sorted
     * Time best = O(n) when already sorted
     * Auxiliary Space = O(1)
     * In-Place
     * Stable
     */
    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int pivot = data[i];
            int walk = i - 1;
            while (walk >= 0 && pivot < data[walk]) {
                data[walk + 1] = data[walk];
                walk--;
            }
            data[walk + 1] = pivot;
        }
    }
}
