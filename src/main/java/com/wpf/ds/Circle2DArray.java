package com.wpf.ds;

import com.wpf.ds.common.PrintUtils;

/**
 * Created by wenpengfei on 2017/10/18.
 */
public class Circle2DArray {

    public static int[][] circle2DArray(int n) {
        if (n == 0) {
            return null;
        }

        int[][] rs = new int[n][];
        for (int i = 0; i < n; ++i) {
            rs[i] = new int[n];
        }

        int k = 1;
        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                rs[i][j] = k++;
            }
            for (int j = i + 1; j < n - i; ++j) {
                rs[j][n - i - 1] = k++;
            }
            for (int j = n - i - 2; j >= i; --j) {
                rs[n - i - 1][j] = k++;
            }
            for (int j = n - i - 2; j > i; --j) {
                rs[j][i] = k++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[][] rs = circle2DArray(5);
        PrintUtils.printInt2D(rs);
    }
}
