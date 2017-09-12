package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/12.
 */
public class StrStr {

    public static int strStr(String s, String p) {
        if (p.length() > s.length()) {
            return -1;
        }

        int[] f = fail(p);
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            while (j > 0 && p.charAt(j) != s.charAt(i)) {
                j = f[j - 1];
            }

            if (p.charAt(j) == s.charAt(i)) {
                j++;
                if (j == p.length()) {
                    return i - j + 1;
                }
            } else {
                j = 0;
            }
        }

        return -1;
    }

    private static int[] fail(String p) {
        int[] f = new int[p.length()];
        for (int i = 1; i < p.length(); ++i) {
            int t = f[i - 1];
            while (t > 0 && p.charAt(t) != p.charAt(i)) {
                t = f[t - 1];
            }

            if (p.charAt(t) == p.charAt(i)) {
                f[i] = t + 1;
            } else {
                f[i] = 0;
            }
        }

        return f;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abaaabaabaab", "aabaa"));
    }
}
