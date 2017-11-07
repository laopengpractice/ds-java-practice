package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/11/1.
 */
public class MaxProductOfWordLength {


    public static int maxProductOfWordLength(String[] strs) {
        int[] bits = new int[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            for (int j = 0; j < strs[i].length(); ++j) {
                bits[i] |= 1 << (strs[i].charAt(j) - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < strs.length; ++i) {
            for (int j = i + 1; j < strs.length; ++j) {
                if ((bits[i] & bits[j]) != 0) {
                    continue;
                }
                int product = strs[i].length() * strs[j].length();
                if (product > max) {
                    max = product;
                }
            }
        }

        return max;
    }
}
