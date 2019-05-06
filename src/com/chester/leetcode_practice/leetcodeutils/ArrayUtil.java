package com.chester.leetcode_practice.leetcodeutils;

import java.util.Random;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 21:53
 * Description:
 */
public class ArrayUtil {

    public static boolean checkSort(int[] data) {
        if (data == null) {
            return true;
        } else {
            int n = data.length;
            if (n == 0 || n == 1) {
                return true;
            } else {
                for (int i = 0; i < data.length - 1; i++) {
                    if (data[i] > data[i + 1]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static int[] createRandomArray(int n, int min, int max) {
        int range = max - min + 1;
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = min + r.nextInt(range);
        }
        return result;
    }

    public static void swap(Object[] data, int a, int b) {
        if (a < data.length && b < data.length && a != b) {
            Object temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    public static void swap(int[] data, int a, int b) {
        if (a < data.length && b < data.length) {
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }
}
