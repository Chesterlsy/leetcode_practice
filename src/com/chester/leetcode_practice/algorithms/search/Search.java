package com.chester.leetcode_practice.algorithms.search;

/**
 * Author: Chester
 * Date: 03/29/2019
 * TIME: 03:26
 * Description:
 */
public interface Search<T extends Comparable<T>> {

    /**
     *
     * @param data every datum must not be null and the array should be sorted increasing.
     * @param target
     * @return
     */
    boolean search(T[] data, T target);
}
