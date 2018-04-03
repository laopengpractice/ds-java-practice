package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import com.wpf.data.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/3.
 */
public class LargestValueInTreeRow {

    public static List<Integer> largestValueInTreeRowBFS(TreeNode root) {
        List<Integer> largest = new ArrayList<>();
        if (root == null) {
            return largest;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        largest.add(root.val);
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : level) {
                if (node.left != null) {
                    newLevel.add(node.left);
                    if (max < node.left.val) {
                        max = node.left.val;
                    }
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                    if (max < node.right.val) {
                        max = node.right.val;
                    }
                }
            }

            if (!newLevel.isEmpty()) {
                largest.add(max);
            }

            level = newLevel;
        }

        return largest;
    }

    public static List<Integer> largestValueInTreeRowDFS(TreeNode root) {
        List<Integer> largest = new ArrayList<>();

        help(root, 0, largest);

        return largest;
    }


    private static void help(TreeNode root, int level, List<Integer> largest) {
        if (root == null) {
            return;
        }

        if (level >= largest.size()) {
            largest.add(root.val);
        } else if (root.val > largest.get(level)) {
            largest.set(level, root.val);
        }

        help(root.left, level + 1, largest);
        help(root.right, level + 1, largest);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(12);
        root.left.right.left = new TreeNode(100);

        List<Integer> bfs = largestValueInTreeRowBFS(root);
        List<Integer> dfs = largestValueInTreeRowDFS(root);

        PrintUtils.printList(bfs);
        PrintUtils.printList(dfs);
    }
}
