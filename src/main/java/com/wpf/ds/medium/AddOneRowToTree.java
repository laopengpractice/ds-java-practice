package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import com.wpf.ds.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class AddOneRowToTree {

    public static TreeNode addOneRowToTreeBfs(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> curNodes = new ArrayList<>();
        curNodes.add(root);
        int cur = 1;
        while (cur != d - 1) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : curNodes) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            curNodes = nextLevel;
            cur++;
        }

        for (TreeNode node : curNodes) {
            TreeNode left = new TreeNode(v);
            left.left = node.left;
            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.left = left;
            node.right = right;
        }

        return root;
    }

    public static TreeNode addOneRowToTreeDfs(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, 1, d, v);

        return root;
    }

    private static void dfs(TreeNode root, int l, int d, int v) {
        if (l == d - 1) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.left = left;
            root.right = right;
            return;
        }

        if (root.left != null) {
            dfs(root.left, l + 1, d, v);
        }
        if (root.right != null) {
            dfs(root.right, l + 1, d, v);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        TreeNode newRoot = addOneRowToTreeBfs(root, 2, 4);
        System.out.println(newRoot.val);
    }
}
