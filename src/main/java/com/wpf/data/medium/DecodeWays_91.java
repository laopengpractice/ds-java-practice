package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/17.
 */
public class DecodeWays_91 {

    public static int decodeWays(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); ++i) {
            int t = cur;
            int c1 = s.charAt(i - 1) - '0';
            int c2 = s.charAt(i) - '0';
            if (c1 * 10 + c2 <= 26) {
                t += pre;
            }
            pre = cur;
            cur = t;
        }

        return cur;
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("123"));
    }
}
