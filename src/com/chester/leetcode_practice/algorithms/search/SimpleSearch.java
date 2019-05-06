package com.chester.leetcode_practice.algorithms.search;

/**
 * Author: Chester
 * Date: 03/29/2019
 * TIME: 02:53
 * Description:
 */
public class SimpleSearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public boolean search(T[] data, T target) {
        if (data == null || data.length == 0 || target == null) {
            return false;
        } else {
            for (T datum : data) {
                if (target.compareTo(datum) == 0) {
                    return true;
                }
            }
            return false;
        }
    }

}
