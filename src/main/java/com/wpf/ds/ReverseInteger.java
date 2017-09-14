package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class ReverseInteger {

    public static int reverseInteger(int n) {
        long ln = n;
        boolean negtive = false;
        if (n < 0) {
            negtive = true;
            ln = Math.abs(n);
        }

        long rs = 0;
        while (ln != 0) {
            rs = rs * 10 + ln % 10;
            ln /= 10;
        }

        if (negtive) {
            rs = -rs;
        }

        if (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)rs;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(Integer.MAX_VALUE));
    }
}
