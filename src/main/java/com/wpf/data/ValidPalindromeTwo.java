package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/18.
 */
public class ValidPalindromeTwo {

    public static boolean validPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int b = -1, e = -1;
        boolean palindrome = true;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            if (b == -1) {
                b = i;
                e = j;
                ++j;
            } else {
                if (palindrome) {
                    palindrome = false;
                    i = b - 1;
                    j = e;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
