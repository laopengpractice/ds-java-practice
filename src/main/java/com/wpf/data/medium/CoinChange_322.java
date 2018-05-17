package com.wpf.data.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/5/15.
 */
public class CoinChange_322 {

    public static int coinChange(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        for (int n : nums) {
            if (n <= amount) {
                dp[n] = 1;
            }
        }

        if (dp[amount] == 1) {
            return 1;
        }

        for (int i = 1; i <= amount; ++i) {
            if (dp[i] == 1) {
                continue;
            }
            int min = -1;
            for (int j = 1; j < i; ++j) {
                if (dp[j] != -1 && dp[i - j] != -1) {
                    if (min == -1) {
                        min = dp[j] + dp[i - j];
                    } else {
                        min = Math.min(min, dp[j] + dp[i - j]);
                    }

                    if (min == 2) {
                        break;
                    }
                }
            }

            dp[i] = min;
        }

        return dp[amount];
    }

    public static int coinChange2(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.sort(nums);

        for (int n : nums) {
            if (n <= amount) {
                dp[n] = 1;
            }
        }

        if (dp[amount] == 1) {
            return 1;
        }

        for (int i = 1; i <= amount; ++i) {
            if (dp[i] == 1) {
                continue;
            }
            int min = -1;
            for (int j = 0; j < nums.length; ++j) {
                if (nums[j] > i) {
                    break;
                }
                if (dp[i - nums[j]] != -1) {
                    if (min == -1) {
                        min = dp[i - nums[j]] + 1;
                    } else {
                        min = Math.min(min, dp[i - nums[j]] + 1);
                    }

                    if (min == 2) {
                        break;
                    }
                }
            }

            dp[i] = min;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};

        System.out.println(coinChange2(nums, 6));
    }
}
