package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wenpengfei on 2017/11/17.
 */
public class BTreeRightView {

    private static Set<Integer> rightSideSet = new HashSet<>();
    private static List<Integer> rs = new ArrayList<>();

    public static List<Integer> rightSizeViewDfs(TreeNode root) {
        dfs(root, 1);

        return rs;
    }

    private static void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (!rightSideSet.contains(level)) {
            rs.add(root.val);
            rightSideSet.add(level);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        PrintUtils.printList(rightSizeViewDfs(root));
    }
}
