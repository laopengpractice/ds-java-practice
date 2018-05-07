package com.wpf.data.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/4/18.
 */
public class CombSum4_377 {

    static int rs4;

    //1 2 3, 4
    public static int combSum4(int[] nums, int target) {
        Arrays.sort(nums);
        help(nums, target);

        return rs4;
    }

    private static void help(int[] nums, int target) {
        if (target == 0) {
            rs4++;
            return;
        }
        if (target < nums[0]) {
            return;
        }


        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            help(nums, t);
        }

        return;
    }

    public static int combSum4_dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            dp[i] = -1;
        }
        help_dp(nums, target, dp);
        return dp[target];
    }

    private static int help_dp(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int rs = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (target < nums[i]) {
                break;
            }
            int t = target - nums[i];
            if (dp[t] == -1) {
                dp[t] = help_dp(nums, t, dp);
            }

            rs += dp[t];
        }

        dp[target] = rs;

        return rs;
    }

    static int rs = 0;

    public static int combSumWithNeg(int[] nums, int target) {
        Arrays.sort(nums);
        helpWithNeg(nums, 0, target);

        return rs;
    }

    private static void helpWithNeg(int[] nums, int idx, int target) {
        if (target == 0) {
            rs++;
        }
        if (idx >= nums.length || (nums[idx] >= 0 && target < nums[idx])) {
            return;
        }


        helpWithNeg(nums, idx + 1, target);
        helpWithNeg(nums, idx + 1, target - nums[idx]);
    }

    public static void main(String[] args) {
        System.out.println(combSum4_dp(new int[]{3, 4, 5, 6, 7, 8, 9, 10}, 10));
    }
}
