package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/24.
 */
public class HouseRobber2_213 {

    public static int houseRobber2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        int rs = Math.max(dp[1], dp[2]);
        for (int i = 2; i < nums.length - 1; ++i) {
            dp[i + 1] = nums[i] + Math.max(dp[i - 1], dp[i - 2]);
            if (rs < dp[i + 1]) {
                rs = dp[i + 1];
            }
        }
        if (nums.length > 2) {
            dp[0] = 0;
            dp[1] = nums[1];
            dp[2] = nums[2];
            rs = Math.max(rs, dp[2]);
            for (int i = 3; i < nums.length; ++i) {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
                if (rs < dp[i]) {
                    rs = dp[i];
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(houseRobber2(new int[]{10, 1, 12, 13, 5, 1, 22}));
    }
}
