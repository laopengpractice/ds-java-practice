package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/20.
 */
public class PerfectSquares_279 {

    //12 4 + 4 + 4 15 9 + 4 + 1 + 1
    public static int squareNum1(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int k = (int)Math.sqrt(i);
            if (k * k == i) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = k; j >= 1; --j) {
                int idx = i - j * j;
                if (1 + dp[idx] < min) {
                    min = dp[idx] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(squareNum1(75));
    }
}
