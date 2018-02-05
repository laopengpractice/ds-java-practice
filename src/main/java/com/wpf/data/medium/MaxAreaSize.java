package com.wpf.data.medium;

import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/25.
 */
public class MaxAreaSize {

    public static int maxAreaSize(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //向右
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!st.empty() && nums[i] < nums[st.peek()]) {
                left[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.empty()) {
            int peek = st.pop();
            left[peek] = nums.length;
        }
        //向左
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!st.empty() && nums[i] < nums[st.peek()]) {
                right[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.empty()) {
            right[st.pop()] = - 1;
        }

        int rs = 0;
        for (int i = 0; i < nums.length; ++i) {
            int area = (left[i] - right[i] - 1) * nums[i];
            if (rs < area) {
                rs = area;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 5, 6, 5, 4, 2, 12, 2, 5, 3};
        System.out.println(maxAreaSize(nums));
    }
}
