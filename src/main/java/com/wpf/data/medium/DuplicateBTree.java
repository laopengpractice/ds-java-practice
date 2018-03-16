package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/3/8.
 */
public class DuplicateBTree {

    public static List<TreeNode> findDuplicateTrees1(TreeNode root) {
        List<TreeNode> allRoots = new ArrayList<>();
        allRoots(root, allRoots);

        Set<TreeNode> rs = new HashSet<>();
        for (int i = 1; i < allRoots.size(); ++i)
            for (int j = i + 1; j < allRoots.size(); ++j) {
                if (duplicate(allRoots.get(i), allRoots.get(j))) {
                    rs.add(allRoots.get(i));
                    break;
                }
            }

        return new ArrayList<>(rs);
    }

    private static void allRoots(TreeNode root, List<TreeNode> rs) {
        if (root == null) {
            return;
        }
        rs.add(root);
        allRoots(root.left, rs);
        allRoots(root.right, rs);
    }

    private static boolean duplicate(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return true;
        }

        if (root1.val == root2.val && duplicate(root1.left, root2.left) && duplicate(root1.right, root2.right)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> rs = findDuplicateTrees1(root);
        for (TreeNode node : rs) {
            System.out.println(node.val);
        }
    }
}
