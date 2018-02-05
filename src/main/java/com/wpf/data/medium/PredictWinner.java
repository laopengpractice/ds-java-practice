package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/11/14.
 */
public class PredictWinner {

    public static boolean predictWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                dp[j][j + i] = Math.max(nums[j] - dp[j + 1][j + i], nums[j + i] - dp[j][j + i - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(predictWinner(new int[]{1, 5, 2}));
        System.out.println(predictWinner(new int[]{1, 5, 233, 7}));
    }
}
