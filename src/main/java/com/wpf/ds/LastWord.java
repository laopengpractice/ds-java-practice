package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/6.
 */
public class LastWord {

    private static int lastWordLength(String word) {
        int rs = 0;
        for (int i = word.length() - 1; i >= 0; --i) {
            if (word.charAt(i) == ' ') {
                if (rs != 0) {
                    return rs;
                }
            } else {
                rs++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(lastWordLength("eafe asrgs  "));
    }
}
