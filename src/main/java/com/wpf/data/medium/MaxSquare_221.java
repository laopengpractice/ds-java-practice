package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/2.
 */
public class MaxSquare_221 {

    public static int maxSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                dp[i][j] = 1;
                if (i > 0 && j > 0) {
                    int left = dp[i][j - 1];
                    int up = dp[i  -1][j];
                    int min = Math.min(left, up);
                    if (dp[i - min][j - min] == '1') {
                        dp[i][j] = min + 1;
                    } else {
                        dp[i][j] = min;
                    }
                }
            }
        }

        int t = dp[matrix.length - 1][matrix[0].length - 1];
        return t * t;
    }
}
