package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/18.
 */
public class IsSubSeq_392 {

    //abc adfbeagd
    public static boolean isSubSequence(String s, String t) {
        boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= t.length(); ++i) {
            dp[i][0] = true;
            for (int j = 1; j <= s.length(); ++j) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if(dp[i - 1][j - 1] && t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public static boolean isSubSeq2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubSequence("abc", "adfbeagd"));
    }
}
