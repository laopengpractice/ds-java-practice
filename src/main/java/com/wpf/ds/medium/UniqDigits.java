package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class UniqDigits {

    public static int uniqDigits(int n) {
        if (n == 1) {
            return 10;
        }
        int rs = 9 * 9;
        int f = 9;
        for (int i = 3; i <= n; ++i) {
            rs *= (10 - i + 1);
        }

        return rs;
    }
}
