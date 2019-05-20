package com.chester.leetcode_practice.problems;

import com.chester.leetcode_practice.leetcodeutils.TreeNode;
import com.chester.leetcode_practice.leetcodeutils.TreeUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 01:16
 * Description:
 */
public class P0654MaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        } else {
            int largest = maxNum(nums, low, high);
            TreeNode node = new TreeNode(nums[largest]);
            node.left = buildTree(nums, low, largest - 1);
            node.right = buildTree(nums, largest + 1, high);
            return node;
        }
    }

    private static int maxNum(int[] data, int low, int high) {
        if (low == high) {
            return low;
        } else {
            int largest = low;
            for (int i = low + 1; i <= high; i++) {
                if (data[i] > data[largest]) {
                    largest = i;
                }
            }
            return largest;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        List<Integer> actual = TreeUtil.levelOrder(constructMaximumBinaryTree(nums));
        for (int i = 0; i < actual.size(); i++) {
            if (actual.get(i) == null) {
                System.out.println("null");
            } else {
                System.out.println(actual.get(i));
            }
        }

    }

    @Test
    void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(3);
        expected.add(5);
        expected.add(null);
        expected.add(2);
        expected.add(0);
        expected.add(null);
        expected.add(null);
        expected.add(1);
        List<Integer> actual = TreeUtil.levelOrder(constructMaximumBinaryTree(nums));
        assertTrue(expected.equals(actual));
    }

    @Test
    void maxTest() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        assertEquals(3, maxNum(nums, 0, nums.length - 1));
        assertEquals(0, maxNum(nums, 0, 0));
    }
}
