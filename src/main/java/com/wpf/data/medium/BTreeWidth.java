package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/2/28.
 */
public class BTreeWidth {

    public static int bTreeWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rs = 1;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int leftIdx = -1;
            int rightIdx = -1;
            int idx = 0;
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < nodes.size(); ++i) {
                TreeNode node = nodes.get(i);
                if (node.left != null) {
                    nextLevel.add(node.left);
                    if (leftIdx == -1) {
                        leftIdx = idx;
                    }
                    rightIdx = idx;
                }
                idx++;
                if (node.right != null) {
                    nextLevel.add(node.right);
                    if (leftIdx == -1) {
                        leftIdx = idx;
                    }
                    rightIdx = idx;
                }
                idx++;
            }

            int width = rightIdx - leftIdx + 1;
            if (width > rs) {
                rs = width;
            }

            nodes = nextLevel;
        }

        return rs;
    }

    public static int bTreeWidth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> leftMosts = new ArrayList<>();
        return dfs(root, 1, 0, leftMosts);
    }

    private static int dfs(TreeNode root, int id, int level, List<Integer> leftMosts) {
        if (root == null) {
            return 0;
        }

        if (leftMosts.size() <= level) {
            leftMosts.add(id);
        }

        int leftDfs = dfs(root.left, id * 2, level + 1, leftMosts);
        int rightDfs = dfs(root.right, id * 2 + 1, level + 1, leftMosts);

        int width = id - leftMosts.get(level) + 1;

        return Math.max(Math.max(width, leftDfs), rightDfs);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        int rs = bTreeWidth2(root);
        System.out.println(rs);
    }
}
