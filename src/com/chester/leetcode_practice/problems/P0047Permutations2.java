package com.chester.leetcode_practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Chester
 * Date: 05/17/2019
 * TIME: 21:57
 * Description:
 */
public class P0047Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), list, new boolean[nums.length]);
        return list;
    }

    /**
     * Duplicate numbers must appear in the order of the sorted nums[].
     * <p>
     * nums[] = {1a, 2, 1c, 3, 1b}
     * sort ->
     * nums[] = {1a, 1b, 1c, 2, 3}
     * 1a always comes first in the lists, then 1b, then 1c.
     * If 1a has not been used, then 1b cannot be added.
     *
     * @param nums
     * @param tempList
     * @param list
     * @param used
     */
    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> list, boolean[] used) {
        int n = nums.length;
        if (tempList.size() == n) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < n; i++) {
                if (used[i]
                        || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(nums, tempList, list, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
