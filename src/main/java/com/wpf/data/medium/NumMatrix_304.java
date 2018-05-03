package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/3.
 */
public class NumMatrix_304 {

    static class NumMatrix {

        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                dp = new int[matrix.length + 1][matrix[0].length + 1];
                dp[0][0] = matrix[0][0];
                for (int i = 1; i <= matrix.length; ++i) {
                    for (int j = 1; j <= matrix[0].length; ++j) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            if (dp == null) {
                return 0;
            }

            return dp[r2 + 1][c2 + 1] - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
