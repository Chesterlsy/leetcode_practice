package com.chester.leetcode_practice.algorithms.search;

import org.junit.jupiter.api.Test;

/**
 * Author: Chester
 * Date: 03/29/2019
 * TIME: 02:25
 * Description:
 */
public class BinarySearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public boolean search(T[] data, T target) {
        if (data == null || data.length == 0 || target == null) {
            return false;
        } else {
            return binarySearch(data, 0, data.length - 1, target);
        }
    }

    private boolean binarySearch(T[] data, int low, int high, T target) {
        if (target.compareTo(data[low]) < 0 || target.compareTo(data[high]) > 0) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (target.compareTo(data[mid]) < 0) {
                return binarySearch(data, low, mid - 1, target);
            } else if (target.compareTo(data[mid]) > 0) {
                return binarySearch(data, mid + 1, high, target);
            } else {
                return true;
            }
        }
    }

    public static boolean binarySearchInt(int[] data, int target) {
        return binarySearchInt(data, 0, data.length - 1, target);
    }

    private static boolean binarySearchInt(int[] data, int low, int high, int target) {
        if (target < data[low] || target > data[high]) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (target < data[mid]) {
                return binarySearchInt(data, low, mid - 1, target);
            } else if (target > data[mid]) {
                return binarySearchInt(data, mid + 1, high, target);
            } else {
                return true;
            }
        }
    }


}
