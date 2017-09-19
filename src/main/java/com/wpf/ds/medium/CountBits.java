package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/9/19.
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] rs = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            rs[i] = rs[i >> 2] + i & 1;
        }

        return rs;
    }
}
