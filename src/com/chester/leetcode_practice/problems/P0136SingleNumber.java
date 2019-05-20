package com.chester.leetcode_practice.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 21:51
 * Description:
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class P0136SingleNumber {

    /**
     *   a ^ 0 = a
     *   a ^ a = 0
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }

    @Test
    void test() {
        int[] nums = {1, 1, 2, 2, 3};
        int expected = 3;
        int acual = singleNumber(nums);
        assertEquals(expected, acual);
    }
}
