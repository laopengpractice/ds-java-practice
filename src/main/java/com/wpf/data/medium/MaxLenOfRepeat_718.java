package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/19.
 */
public class MaxLenOfRepeat_718 {

    public static int findLength(int[] a, int[] b) {
        int[][] dp = new int[2][b.length + 1];
        int cur = 0;
        for (int i = 1; i <= a.length; ++i) {
            int next =cur ^ 1;
            for (int j = 1; j <= b.length; ++j) {
                if (a[i - 1] == b[j - 1]) {
                    dp[next][j] = dp[cur][j - 1] + 1;
                } else {
                    dp[next][j] = Math.max(dp[cur][j], dp[next][j - 1]);
                }
            }
            cur = next;
        }

        return dp[cur][b.length];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b= {5, 4, 1, 2, 3, 4};

        System.out.println(findLength(a, b));
    }
}
