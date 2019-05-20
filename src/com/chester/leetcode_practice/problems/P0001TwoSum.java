package com.chester.leetcode_practice.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Chester
 * Date: 03/30/2019
 * TIME: 03:07
 * Description:
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class P0001TwoSum {

    /**
     * Time complexity : O(n^2).
     * For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time.
     * Therefore, the time complexity is O(n^2).
     *
     * Space complexity : O(1).
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                if (nums[i] + nums[j] > target) { // optimize
                    break;
                }
            }
        }
        return null;
    }

    /**
     * Approach 2: Two-pass Hash Table
     *
     * To improve our run time complexity, we need a more efficient way to check if the complement exists in the array.
     * If the complement exists, we need to look up its index.
     * What is the best way to maintain a mapping of each element in the array to its index? A hash table.
     *
     * Time complexity : O(n).
     * We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
     *
     * Space complexity : O(n).
     * The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSumMap(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }

    /**
     * Approach 3: One-pass Hash Table
     *
     * It turns out we can do it in one-pass. While we iterate and inserting elements into the table,
     * we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     *
     * Time complexity : O(n).
     * We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
     *
     * Space complexity : O(n).
     * The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSumHashMap(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * n integers add up to target. No duplicates.
     * @param nums distinct integer array
     * @param n
     * @param target
     * @return
     */
    static List<List<Integer>> nSumBacktrack(int[] nums, int n, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int remain = target;
        backtrack(nums, n, target, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] nums, int n, int remain, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == n) {
            if (remain == 0) {
                list.add(new ArrayList<>(tempList));
            } else {
                return;
            }
        } else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    backtrack(nums, n, remain - num, tempList, list);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    @Test
    void test1() {
        int[] data = {2, 7 ,11 ,15};
        int[] result = {0, 1};
        assertArrayEquals(result, twoSumBruteForce(data, 9));
    }

    @Test
    void test2() {
        int[] data = {2, 7};
        int[] result = {0, 1};
        assertArrayEquals(result, twoSumBruteForce(data, 9));
    }

    @Test
    void test3() {
        int[] data = {-1, 0, 1, 2, 7};
        int[] result = {3, 4};
        assertArrayEquals(result, twoSumBruteForce(data, 9));
    }
}
