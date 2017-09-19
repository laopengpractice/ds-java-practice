package com.wpf.ds.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wenpengfei on 2017/9/19.
 */
public class BottomLeftTreeValue {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int bottomLeftTreeValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int rs = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            rs = q.peek().val;
            for (int i = 0; i < size; ++i) {
                TreeNode item = q.poll();
                if (item.left != null) {
                    q.add(item.left);
                }
                if (item.right != null) {
                    q.add(item.right);
                }
            }
        }

        return rs;
    }

    static class Pair {
        int val;
        int high;

        public Pair(int val, int high) {
            this.val = val;
            this.high = high;
        }
    }

    public static int process2(TreeNode root) {
        return help(root).val;
    }

    private static Pair help(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair l = help(root.left);
        Pair r = help(root.right);
        if (l.high == r.high) {
            if (l.high == 0) {
                return new Pair(root.val, l.high + 1);
            }
            return new Pair(l.val, l.high + 1);
        } else if (l.high > r.high) {
            return new Pair(l.val, l.high + 1);
        } else {
            return new Pair(r.val, r.high + 1);
        }
    }
}
