package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/10.
 */
public class MinAsciiDelete_712 {

    public static int minDeleteSum(String s1, String s2) {
        int[][] dp = new int[2][s2.length() + 1];

        for (int i = 1; i <= s2.length(); ++i) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }

        int cur = 0;
        for (int i = 1; i <= s1.length(); ++i) {
            int next = cur ^ 1;
            dp[next][0] = dp[cur][0] + s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); ++j) {
                dp[next][j] = Math.min(dp[cur][j] + s1.charAt(i - 1), dp[next][j - 1] + s2.charAt(j - 1));
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[next][j] = Math.min(dp[next][j], dp[cur][j - 1]);
                }
            }
            cur = next;
        }

        return dp[cur][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDeleteSum("delete", "leet"));
    }
}
