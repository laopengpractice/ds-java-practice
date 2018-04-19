package com.wpf.data.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/4/19.
 */
public class CanPartition_416 {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        return fillTarget(nums, target);
    }

    private static boolean fillTarget(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];

        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]] + nums[i - 1] > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                }
            }
        }

        return dp[nums.length][target] == target;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 5, 5, 8}));
    }
}
