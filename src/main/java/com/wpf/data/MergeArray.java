package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/6.
 */
public class MergeArray {

    public static void mergeArray(int[] n1, int m, int[] n2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (n1[i] > n2[j]) {
                n1[k--] = n1[i--];
            } else {
                n1[k--] = n2[j--];
            }
        }
        while (j >= 0) {
            n1[k--] = n2[j--];
        }
    }
}
