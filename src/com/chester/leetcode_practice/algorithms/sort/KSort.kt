package com.chester.leetcode_practice.algorithms.sort

class KSort {

    fun kSort(data: MutableList<Int>): List<Int> {
        data.forEachIndexed { index, i ->
            data[i] = index
        }
        return data
    }
}