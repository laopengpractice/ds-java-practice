package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/17.
 */
public class KeyKeyBoard_650 {

    public static int minSteps(int num) {
        int[] dp = new int[num + 1];
        for (int i = 2; i <= num; ++i) {
            dp[i] = i;
            for (int j = i - 1; j > 1; --j) {
                if (i % j == 0) {
                    int tmp = dp[j] + (i / j);
                    dp[i] = Math.min(dp[i], tmp);
                }
            }
        }

        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(8));
    }
}
