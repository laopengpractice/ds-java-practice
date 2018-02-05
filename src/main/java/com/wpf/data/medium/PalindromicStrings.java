package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/9/20.
 */
public class PalindromicStrings {

    public static int palindromicStrings(String s) {
        int len = s.length();
        int rs = s.length();
        boolean p1[] = new boolean[len];
        boolean p2[] = new boolean[len];

        for (int i = 2; i <= len; ++i) {
            for (int j = 0; j <= len - i; ++j) {
                if (s.charAt(j) == s.charAt(j + i - 1) && !p1[j + 1]) {
                    rs++;
                } else {
                    p1[j] = true;
                }
            }
            boolean t[] = p1;
            p1 = p2;
            p2 = t;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(palindromicStrings("aaaa"));
    }
}
