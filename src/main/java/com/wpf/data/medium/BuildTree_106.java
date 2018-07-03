package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/6/27.
 */
public class BuildTree_106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        int idx = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int[] leftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] leftPost = Arrays.copyOfRange(postorder, 0, idx);
        root.left = buildTree(leftIn, leftPost);

        int[] rightIn = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] rightPost = Arrays.copyOfRange(postorder, idx + 1, postorder.length);
        root.right = buildTree(rightIn, rightPost);

        return root;
    }

    public static TreeNode buildTree2(int[] in, int[] post) {
        return null;
    }

}
