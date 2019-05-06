package com.chester.leetcode_practice.algorithms.sort;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 22:23
 * Description:
 */
public interface Sort<T extends Comparable<T>> {
    /**
     *
     * @param data every datum must not be null.
     * @return
     */
    void sort(T[] data);

    void sort(int[] data);
}
