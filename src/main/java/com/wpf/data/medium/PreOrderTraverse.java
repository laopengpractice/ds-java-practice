package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/25.
 */
public class PreOrderTraverse {

    public static List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        rs.add(root.val);
        while (!s.empty()) {
            TreeNode t = s.peek();
            while (t.left != null) {
                s.push(t.left);
                rs.add(t.left.val);
                t = t.left;
            }
            t = s.pop();
            while (!s.empty() && t.right == null) {
                t = s.pop();
            }
            if (t.right != null) {
                s.push(t.right);
                rs.add(t.right.val);
            }
        }

        return rs;
    }
}
