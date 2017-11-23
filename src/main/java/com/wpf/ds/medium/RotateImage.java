package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;

/**
 * Created by wenpengfei on 2017/11/23.
 */
public class RotateImage {

    public static void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                int t = m[i][n - j - 1];
                m[i][n - j - 1] = m[j][i];
                m[j][i] = m[n - 1 - i][j];
                m[n - 1 - i][j] = m[n - j - 1][n - i - 1];
                m[n - j - 1][n - i - 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] t = new int[4][];
        t[0] = new int[]{1, 2, 3, 4};
        t[1] = new int[]{5, 6, 7, 8};
        t[2] = new int[]{9, 10, 11, 12};
        t[3] = new int[]{13, 14, 15, 16};
        rotate(t);
        PrintUtils.printInt2D(t);
    }
}
