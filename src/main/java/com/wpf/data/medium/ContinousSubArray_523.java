package com.wpf.data.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/5/15.
 */
public class ContinousSubArray_523 {

    public static boolean continousSubArray(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int[] dp = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = dp[i - 1] + nums[i - 1];
            if (dp[i] % k == 0) {
                return true;
            }
            for (int j = i - 2; j >= 0; --j) {
                if ((dp[i] - dp[j]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean continousSubArray2(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = dp[i - 1] + nums[i];
            int remain = dp[i] % k;
            if (set.contains(remain)) {
                return true;
            }

            set.add(remain);
        }

        return false;
    }
}
