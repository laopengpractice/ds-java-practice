package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/3/16.
 */
public class CommonAncestor {

    public static TreeNode commonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        boolean found1 = help(root, n1, path1);
        boolean found2 = help(root, n2, path2);

        if (!found1 || !found2) {
            return null;
        }

        int i = 1;
        for (; i < path1.size() && i < path2.size(); ++i) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    private static boolean help(TreeNode root, TreeNode found, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == found) {
            path.add(found);
            return true;
        }

        path.add(root);
        boolean left = help(root.left, found, path);
        if (left) {
            return true;
        }

        boolean right = help(root.right, found, path);
        if (right) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }
}
