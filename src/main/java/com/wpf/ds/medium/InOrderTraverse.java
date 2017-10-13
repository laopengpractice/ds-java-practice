package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import com.wpf.ds.common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/13.
 */
public class InOrderTraverse {

    public static List<Integer> inorderTraverse1(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        doTraver(root, rs);
        return rs;
    }

    private static void doTraver(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        doTraver(root.left, rs);
        rs.add(root.val);
        doTraver(root.right, rs);
    }

    public static List<Integer> inorderTraverse2(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode cur = s.peek();
            while (cur.left != null) {
                s.push(cur.left);
                cur = cur.left;
            }
            s.pop();
            rs.add(cur.val);
            while (!s.empty() && cur.right == null) {
                cur = s.pop();
                rs.add(cur.val);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);

        List<Integer> rs = inorderTraverse1(root);
        PrintUtils.printList(rs);
        List<Integer> rs2 = inorderTraverse2(root);
        PrintUtils.printList(rs2);
    }
}
