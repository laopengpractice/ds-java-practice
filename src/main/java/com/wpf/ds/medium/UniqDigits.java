package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class UniqDigits {

    public static int uniqDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int rs = 10;
        int pre = 9;
        for (int i = 2; i <= n; ++i) {
            rs += pre * (10 - i + 1);
            pre *= (10 - i + 1);
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(uniqDigits(4));
    }
}
