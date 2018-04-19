package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/19.
 */
public class FindMaxForm_474 {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[] num0 = new int[strs.length];
        int[] num1 = new int[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    num0[i]++;
                } else {
                    num1[i]++;
                }
            }
        }

        for (int i = 1; i <= strs.length; ++i) {
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (num0[i - 1] <= j && num1[i - 1] <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - num0[i - 1]][k - num1[i - 1]] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "1", "0"}, 1, 1));
    }
}
