package com.chester.leetcode_practice.leetcodeutils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 01:37
 * Description:
 */
public class TreeUtil {


    public static List<Integer> levelOrder(TreeNode root) {
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            int h = height(root);
            for (int i = 1; i <= h; i++) {
                visitLevel(root, i, list);
            }
            return list;
        } else {
            return null;
        }

    }

    public static void visitLevel(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            if (level == 1) {
                list.add(null);
            }
        } else {
            if (level == 1) {
                list.add(root.val);
            } else if (level > 1) {
                visitLevel(root.left, level - 1, list);
                visitLevel(root.right, level - 1, list);
            }
        }
    }

    /**
     * leaf height = 1
     * @param node
     * @return
     */
    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    @Test
    void visitTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            expected.add(i);
        }
        expected.add(null);
        List<Integer> actual = levelOrder(root);
        assertTrue(expected.equals(actual));
    }
}
