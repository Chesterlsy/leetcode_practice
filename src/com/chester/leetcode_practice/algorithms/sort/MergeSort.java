package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 23:19
 * Description:
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] data) {

    }

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    public static void mergeSort(int[] data, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);
            merge3(data, low, mid, high);
        }
    }

    private static void merge(int[] data, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = data[low + i];
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = data[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                data[k++] = a1[i++];
            } else {
                data[k++] = a2[j++];
            }
        }
        while (i < n1) {
            data[k++] = a1[i++];
        }
        while (j < n2) {
            data[k++] = a2[j++];
        }
    }

    private static void merge2(int[] data, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = data[low + i];
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = data[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (k <= high) {
            if (j == n2) {
                data[k++] = a1[i++];
            } else if (i == n1) {
                data[k++] = a2[j++];
            } else {
                if (a1[i] < a2[j]) {
                    data[k++] = a1[i++];
                } else {
                    data[k++] = a2[j++];
                }
            }
        }
    }

    /**
     * In place
     * @param data
     * @param low
     * @param mid
     * @param high
     */
    private static void merge3(int[] data, int low, int mid, int high) {
        int i = low, j = mid + 1;

        if (data[mid] < data[mid + 1]) {
            return;
        }

        while(i <= mid && j <= high) {
            if (data[i] <= data[j]) {
                i++;
            } else {
                int pivot = data[j];
                for (int k = j; k >= i + 1; k--) {
                    data[k] = data[k - 1];
                }
                data[i] = pivot;
                i++;
                mid++;
                j++;
            }
        }
    }

}
