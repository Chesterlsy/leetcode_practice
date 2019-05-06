package com.chester.leetcode_practice.datastructures.tree;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 00:46
 * Description:
 */
public class BinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + "");
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "");
            inOrder(root.right);
        }
    }

    public static void levelOrder(TreeNode root) {
        if (root != null) {
            int h = height(root);
            for (int i = 1; i <= h; i++) {
                visitLevel(root, i);
            }
        }
    }

    public static void visitLevel(TreeNode root, int level) {
        if (root != null) {
            if (level == 1) {
                System.out.print(root.val + "");
            } else if (level > 1) {
                visitLevel(root.left, level - 1);
                visitLevel(root.right, level - 1);
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

    public static int depth(TreeNode node) {
        if (node.parent == null) { // is root
            return 0;
        } else {
            return 1 + depth(node.parent);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("PreOrder: ");
        preOrder(root);
        System.out.println("\n");

        System.out.println("PostOrder: ");
        postOrder(root);
        System.out.println("\n");

        System.out.println("InOrder: ");
        inOrder(root);
        System.out.println("\n");

        System.out.println("LevelOrder: ");
        levelOrder(root);
        System.out.println("\n");
    }

}
