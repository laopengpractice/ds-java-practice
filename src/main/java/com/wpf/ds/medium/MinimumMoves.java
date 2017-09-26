package com.wpf.ds.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/9/26.
 */
public class MinimumMoves {

    public static int minimumMoves(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int rs = 0;
        while (i < j) {
            rs += nums[j] - nums[i];
            j--;
            i++;
        }

        return rs;
    }
}
