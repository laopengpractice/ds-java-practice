package com.wpf.ds.medium;

import com.wpf.ds.common.TreeNode;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/11/10.
 */
public class BSTreeIter {

    private Stack<TreeNode> st;

    public BSTreeIter(TreeNode root) {
        st = new Stack<>();
        if (root != null) {
            st.push(root);
            while (root.left != null) {
                st.push(root.left);
            }
        }
    }

    public boolean hasNext() {
        return !st.empty();
    }

    public int next() {
        TreeNode item = st.pop();
        int rs = item.val;
        item = item.right;
        if (item != null) {
            st.push(item);
            while (item.left != null) {
                st.push(item.left);
                item = item.left;
            }
        }

        return rs;
    }
}
