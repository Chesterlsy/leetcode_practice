package com.chester.leetcode_practice.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Chester
 * Date: 03/29/2019
 * TIME: 03:07
 * Description:
 */
class SearchTest {

    private SimpleSearch<Integer> simpleSearchInt = new SimpleSearch<>();
    private BinarySearch<Integer> binarySearchInt = new BinarySearch<>();

    @Test
    void simpleSearchTest() {
        normalCase(simpleSearchInt);
        boundaryCase(simpleSearchInt);
        greatSizeCase(simpleSearchInt);
    }

    @Test
    void binarySearchTest() {
        normalCase(binarySearchInt);
        boundaryCase(binarySearchInt);
        greatSizeCase(binarySearchInt);
    }

    private void normalCase(Search<Integer> search) {
        Integer[] data = {-3, 0, 1, 3, 4, 5};
        assertFalse(search.search(data, null));
        assertFalse(search.search(data, -4));
        assertTrue(search.search(data, -3));
        assertTrue(search.search(data, 1));
        assertFalse(search.search(data, 2));
        assertTrue(search.search(data, 5));
        assertFalse(search.search(data, 6));
    }

    private void boundaryCase(Search<Integer> search) {
        Integer[] data1 = null;
        assertFalse(search.search(data1, null));
        assertFalse(search.search(data1, 1));

        Integer[] data2 = new Integer[0];
        assertFalse(search.search(data2, null));
        assertFalse(search.search(data2, 0));
        assertFalse(search.search(data2, 1));

//        Integer[] data3 = new Integer[5];
//        assertFalse(search.search(data3, null));
//        assertFalse(search.search(data3, 0));
//        assertFalse(search.search(data3, 1));
    }

    private void greatSizeCase(Search<Integer> search) {
        Integer[] data = new Integer[1000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        assertTrue(search.search(data, 1));
        assertTrue(search.search(data, 555555));
        assertTrue(search.search(data, 999999));
    }

}
