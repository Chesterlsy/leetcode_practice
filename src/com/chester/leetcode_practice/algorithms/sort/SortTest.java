package com.chester.leetcode_practice.algorithms.sort;

import com.chester.leetcode_practice.leetcodeutils.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Chester
 * Date: 05/06/2019
 * TIME: 22:40
 * Description:
 */
class SortTest {

    @Test
    void testTest() {
        for (int i = 0; i < 10; i++) {
            int[] data = ArrayUtil.createRandomArray(10000, -50, 50);
            Arrays.sort(data);
            assertTrue(ArrayUtil.checkSort(data));
        }
    }

    @Test
    void bubbleSortTest() {
        Sort bubbleSort = new BubbleSort();
        sortCase(bubbleSort);
    }

    @Test
    void selectionSortTest() {
        Sort selectionSort = new SelectionSort();
        sortCase(selectionSort);
    }

    @Test
    void insertionSortTest() {
        Sort insertionSort = new InsertionSort();
        sortCase(insertionSort);
    }

    @Test
    void mergeSortTest() {
        Sort mergeSortTest = new MergeSort();
        sortCase(mergeSortTest);
    }

    @Test
    void quickSortTest() {
        Sort quickSortTest = new QuickSort();
        sortCase(quickSortTest);
    }

    @Test
    void heapSortTest() {
        Sort heapSortTest = new HeapSort();
        sortCase(heapSortTest);
    }

    private void sortCase(Sort<Integer> sort) {
        for (int i = 0; i < 100; i++) {
            int[] data = ArrayUtil.createRandomArray(10000, -5000, 5000);
            sort.sort(data);
            assertTrue(ArrayUtil.checkSort(data));
        }
    }
}
