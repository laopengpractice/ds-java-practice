package com.wpf.ds.medium;

import java.util.Stack;
import sun.reflect.generics.tree.Tree;

/**
 * Created by wenpengfei on 2017/9/18.
 */
public class MaxBinaryTree {

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode maxBinaryTree2(int[] nums) {
        if (nums == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode node = new TreeNode(nums[i]);
            if (!stack.empty()) {
                TreeNode item = null;
                while (!stack.empty() && stack.peek().val < node.val) {
                    stack.peek().right = item;
                    item = stack.pop();
                }
                node.left = item;
            }
            stack.push(node);
        }
        if (stack.empty()) {
            return null;
        }

        TreeNode item = stack.pop();
        while (!stack.empty()) {
            stack.peek().right = item;
            item = stack.pop();
        }

        return item;
    }

    public static TreeNode  maxBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildMaxTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildMaxTree(int[] nums, int b, int e) {
        if (b > e) {
            return null;
        }

        int max = e;
        for (int i = b; i < e; ++i) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = buildMaxTree(nums, b, max - 1);
        root.right = buildMaxTree(nums, max + 1, e);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = maxBinaryTree(new int[]{1, 2, 5, 3, 4, 10, 6, 9, 8});
        System.out.println(root);
    }
}
