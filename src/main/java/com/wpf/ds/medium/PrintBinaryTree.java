package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import com.wpf.ds.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/9/27.
 */
public class PrintBinaryTree {

    public static String[][] printBinaryTree(TreeNode root) {
        if (root == null) {
            return new String[0][];
        }
        int height = height(root);
        int size = (int)Math.pow(2, height) - 1;

        String[][] rs = new String[height][];
        for (int i = 0; i < height; ++i) {
            String[] line = new String[size];
            for (int j = 0; j < size; ++j) {
                line[j] = "";
            }
            rs[i] = line;
        }
        doPrint(root, rs, 0, 0, size - 1);

        return rs;
    }

    private static void doPrint(TreeNode root, String[][] rs, int h, int start, int end) {
        int m = (start + end) / 2;
        if (root != null) {
            rs[h][m] = String.valueOf(root.val);
            doPrint(root.left, rs, h + 1, start, m - 1);
            doPrint(root.right, rs, h + 1, m + 1, end);
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        PrintUtils.print(printBinaryTree(root));
    }
}
