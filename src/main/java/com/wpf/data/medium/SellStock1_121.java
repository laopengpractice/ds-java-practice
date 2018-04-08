package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/8.
 */
public class SellStock1_121 {

    public static int sellStock(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int buy = nums[0];
        int profit = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                if (nums[i] - buy > profit) {
                    profit = nums[i] - buy;
                }
            } else if (nums[i] < buy) {
                buy = nums[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(sellStock(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
