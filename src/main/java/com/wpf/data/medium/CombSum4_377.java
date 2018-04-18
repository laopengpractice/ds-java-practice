package com.wpf.data.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/4/18.
 */
public class CombSum4_377 {

    //1 2 3, 4
    public static int combSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        help(nums, target, dp);

        return dp[target];
    }

    private static int help(int[] nums, int target, int[] dp) {
        if (target < nums[0]) {
            dp[target] = 0;
            return 0;
        }

        if (target == nums[0]) {
            dp[target] = 1;
            return 1;
        }

        int rs = 0;
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            while (t > 0) {
                if (dp[t] == -1) {
                    dp[t] = combSum4(nums, t);
                }
                rs += dp[t];
                t -= nums[i];
            }
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
        System.out.println(combSumWithNeg(new int[]{-1, 1, 2, 3}, 5));
    }
}
