package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;

/**
 * Created by wenpengfei on 2017/11/6.
 */
public class HouseRobber3 {

    public static int houseRobber3(TreeNode root) {
        return help(root, false);
    }

    private static int help(TreeNode root, boolean use) {
        if (root == null) {
            return 0;
        }

        int left = help(root.left, false);
        int right = help(root.right, false);

        if (use) {
            return left + right;
        }

        int val = root.val;
        int leftUse = help(root.left, true);
        int rightUse = help(root.right, true);

        return Math.max(val + leftUse + rightUse, left + right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        System.out.println(houseRobber3(root));
    }
}
