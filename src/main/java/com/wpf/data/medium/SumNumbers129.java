package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;

/**
 * Created by wenpengfei on 2018/3/27.
 */
public class SumNumbers129 {

    static int rs = 0;

    public static int sumNumbers129(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root, 0);

        return rs;
    }

    private static void help(TreeNode root, int cur) {

        cur = cur * 10 + root.val;

        if (root.left == null && root.right == null) {
            rs += cur;
            return;
        }

        if (root.left != null) {
            help(root.left, cur);
        }

        if (root.right != null) {
            help(root.right, cur);
        }

    }
}
