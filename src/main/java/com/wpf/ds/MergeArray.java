package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/6.
 */
public class MergeArray {

    public static void mergeArray(int[] n1, int m, int[] n2, int n) {
        int[] tmp = new int[m];
        for (int i = 0 ; i< m; ++i) {
            tmp[i] = n1[i];
        }
        int k = 0, i = 0, j = 0;
        while (i < m && j < n2.length) {
            if (tmp[i] < n2[j]) {
                n1[k++] = tmp[i++];
            } else {
                n1[k++] = n2[j++];
            }
        }
        while (i < m) {
            n1[k++] = tmp[i++];
        }
        while (j < n2.length) {
            n1[k++] = n2[j++];
        }

        return;
    }
}
