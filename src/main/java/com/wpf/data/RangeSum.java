package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/18.
 */
public class RangeSum {

    public static int rangeSum(int[] nums, int b, int e) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }

        return sums[e] - sums[b] + nums[b];
    }
}
