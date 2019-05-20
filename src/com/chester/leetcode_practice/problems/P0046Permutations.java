package com.chester.leetcode_practice.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 22:54
 * Description:
 * Given a collection of distinct integers, return all possible permutations.
 */
public class P0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        collectPermutations(nums, 0, new ArrayList<>(), list);
        return list;
    }

    /**
     *
     * @param nums data set
     * @param i current datum at i to be added to permutation. i = permutation.size()
     * @param permutation current permutation  with i numbers
     * @param list result list
     */
    private static void collectPermutations(int[] nums, int i, List<Integer> permutation, List<List<Integer>> list) {
        if (permutation.size() == nums.length) {
            list.add(permutation);
            return;
        }
        for (int j = 0; j <= permutation.size(); j++) { // insert nums[i] at position j of current array
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(j, nums[i]);
            collectPermutations(nums, i + 1, newPermutation, list);
        }
    }

    /**
     * Backtracking algorithm (DFS)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), list);
        return list;
    }

    /**
     * Create new list right when add to the list
     * @param nums
     * @param tempList
     * @param list
     */
    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList)); // create new list right when add to the list
        } else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    backtrack(nums, tempList, list);
                    tempList.remove(tempList.size() - 1); // remove last num which was added during last loop
                }
            }
        }
    }

    /**
     * Slower version
     * Create new list when need to add new num
     * @param nums
     * @param tempList
     * @param list
     */
    private static void backtrack2(int[] nums, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == nums.length) {
            list.add(tempList);
        } else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    List<Integer> newList = new ArrayList<>(tempList); // create new list when need to add new num
                    newList.add(num);
                    backtrack(nums, newList, list);
                }
            }
        }
    }


}
