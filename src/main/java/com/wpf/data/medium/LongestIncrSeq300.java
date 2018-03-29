package com.wpf.data.medium;

import java.util.*;

/**
 * Created by wenpengfei on 2018/3/28.
 */
public class LongestIncrSeq300 {

    public static int longestIncrSeq(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    static class Pair {
        int val;
        int idx;
    }

    public static int longestIncrSeqNlgn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            int l = 0, r = dp.size() - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (dp.get(m) == nums[i]) {
                    l = m;
                    break;
                } else if (dp.get(m) > nums[i]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            if (l >= dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(l, nums[i]);
            }
        }

        return dp.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncrSeqNlgn(nums));
    }
}
