package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;

/**
 * Created by wenpengfei on 2017/11/6.
 */
public class KthInBST {

    static int val;
    static int t;

    public static int kthInBST(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private static void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);
        t++;
        if (t == k) {
            val = root.val;
            return;
        }
        inOrder(root.right, k);
    }


}
