package com.chester.leetcode_practice.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Chester
 * Date: 05/08/2019
 * TIME: 01:11
 * Description:
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
public class P0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int num : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubSet = new ArrayList<>(list.get(i));
                newSubSet.add(num);
                list.add(newSubSet);
            }
        }

        return list;
    }

}
