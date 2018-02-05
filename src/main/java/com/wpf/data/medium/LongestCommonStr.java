package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/11/6.
 */
public class LongestCommonStr {

    public static int longestCommonStr(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }

        int max = 0;
        int[][] dp = new int[2][s2.length() + 1];
        int pre = 0, cur = 1;
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[cur][j] = 0;
                } else {
                    dp[cur][j] = dp[pre][j - 1] + 1;
                    if (dp[cur][j] > max) {
                        max = dp[cur][j];
                    }
                }
            }
            int tmp = cur;
            cur = pre;
            pre = tmp;
        }

        return max;
    }
}
