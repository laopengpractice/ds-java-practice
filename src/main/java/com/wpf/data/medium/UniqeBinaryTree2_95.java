package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import com.wpf.data.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/27.
 */
public class UniqeBinaryTree2_95 {

    public static List<TreeNode> generateTrees(int n) {
        return help(1, n);
    }

    private static List<TreeNode> help(int b, int e) {
        List<TreeNode> rs = new ArrayList<>();
        if (b > e) {
            rs.add(null);
            return rs;
        }
        if (b == e) {
            TreeNode node = new TreeNode(b);
            rs.add(node);
            return rs;
        }

        for (int i = b; i <= e; ++i) {
            List<TreeNode> lefts = help(b, i - 1);
            List<TreeNode> rights = help(i + 1, e);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    rs.add(head);
                }
            }
        }

        return rs;
    }

    public static List<TreeNode> generateTrees2(int n) {
        List<TreeNode>[] rs = new List[n + 1];
        List<TreeNode> nullTree = new ArrayList<>();
        nullTree.add(null);
        rs[0] = nullTree;
        for (int i = 1; i <= n; ++i) {
            rs[i] = new ArrayList<>();
            for (int j = 1; j <= i; ++j) {
                List<TreeNode> lefts = rs[j - 1];
                List<TreeNode> rights = rs[i - j];
                for (TreeNode left : lefts)
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        rs[i].add(root);
                    }
            }
        }

        return rs[n];
    }

    public static TreeNode clone(TreeNode root, int offset) {
        if (root == null || offset == 0) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val + offset);
        TreeNode left = clone(root.left, offset);
        TreeNode right = clone(root.right, offset);
        newRoot.left = left;
        newRoot.right = right;
        return newRoot;
    }

    public static void main(String[] args) {
        List<TreeNode> rs = generateTrees2(4);
        for (TreeNode root : rs) {
            PrintUtils.printLevelTree(root);
        }
    }
}
