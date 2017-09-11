package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/11.
 */
public class ShortestUnsorted {

    public static int shortestUnsorted(int[] nums) {
        int start = -1;
        int max = -1;
        int end = -2;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (start == -1) {
                if (nums[i] > nums[i + 1]) {
                    max = start = i;
                    end = i + 1;
                }
            } else {
                if (nums[i] >= nums[max]) {
                    max = i;
                } else {
                    end = i;
                }
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(shortestUnsorted(new int[]{5, 4, 3, 2, 10, 11, 8, 5}));
    }
}
