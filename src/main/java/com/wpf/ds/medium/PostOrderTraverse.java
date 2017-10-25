package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import com.wpf.ds.common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/25.
 */
public class PostOrderTraverse {

    public static List<Integer> postOrderTraverse(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        Stack<TreeNode> st = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        st.push(root);
        visited.push(false);
        while (!st.empty()) {
            TreeNode t = st.peek();
            while (t.left != null) {
                st.push(t.left);
                visited.push(false);
                t = t.left;
            }

            while (!visited.empty() && (visited.peek() || st.peek().right == null)) {
                rs.add(st.peek().val);
                st.pop();
                visited.pop();
            }

            if (!visited.empty() && !visited.peek() && st.peek().right != null) {
                visited.pop();
                visited.push(true);
                st.push(st.peek().right);
                visited.push(false);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        List<Integer> rs = postOrderTraverse(root);
        PrintUtils.printList(rs);
    }
}
