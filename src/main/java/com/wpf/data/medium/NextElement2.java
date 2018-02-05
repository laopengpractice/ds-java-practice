package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/16.
 */
public class NextElement2 {

    public static int[] nextElement2(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] next = new int[nums.length];
        Arrays.fill(next, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length * 2; ++i) {
            while (!s.empty() && nums[s.peek()] < nums[i % nums.length]) {
                next[s.pop()] = i;
            }
            if (i < nums.length) {
                s.push(i);
            }
        }

        return next;
    }



    public static void main(String[] args) {
        int[] rs = nextElement2(new int[]{1, 2, 1});
        PrintUtils.printInt(rs);
    }
}
