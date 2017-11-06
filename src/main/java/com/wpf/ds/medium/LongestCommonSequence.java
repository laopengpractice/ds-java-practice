package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/11/6.
 */
public class LongestCommonSequence {

    public static int longestCommonSequence(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[s1.length() + 1][];
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = new int[s2.length() + 1];
        }

        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                int equal = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0;
                dp[i][j] = Math.max(dp[i - 1][j - 1] + equal, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static int longestCommonSeq2(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[2][s2.length() + 1];
        int pre = 0, cur = 1;
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                int equal = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0;
                dp[cur][j] = Math.max(dp[pre][j - 1] + equal, Math.max(dp[pre][j], dp[cur][j - 1]));
            }
            int tmp = cur;
            cur = pre;
            pre = tmp;
        }

        return dp[pre][s2.length()];
    }

    public static String longestCommonSeq3(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return "";
        }

        int[][] dp = new int[2][s2.length() + 1];
        StringBuilder[][] commonSeq = new StringBuilder[2][s2.length() + 1];
        for (int i = 0; i <= s2.length(); ++i) {
            commonSeq[0][i] = new StringBuilder();
        }
        commonSeq[1][0] = new StringBuilder();
        int pre = 0, cur = 1;
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                StringBuilder sb = new StringBuilder();
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[cur][j] = dp[pre][j - 1] + 1;
                    sb.append(commonSeq[pre][j - 1].toString()).append(s1.charAt(i - 1));
                } else {
                    String prefix;
                    if (dp[pre][j] > dp[cur][j - 1]) {
                        dp[cur][j] = dp[pre][j];
                        prefix = commonSeq[pre][j].toString();
                    } else {
                        dp[cur][j] = dp[cur][j - 1];
                        prefix = commonSeq[cur][j - 1].toString();
                    }
                    sb.append(prefix);
                }
                commonSeq[cur][j] = sb;
            }
            int tmp = cur;
            cur = pre;
            pre = tmp;
        }

        return commonSeq[pre][s2.length()].toString();
    }

    public static void main(String[] args) {
    }
}
