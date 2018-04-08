package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/8.
 */
public class SellStock2_122 {

    public static int max(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < nums.length; ++i) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                i++;
            }
            profit += nums[i] - nums[start];
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{8, 7, 6, 5}));
    }
}
