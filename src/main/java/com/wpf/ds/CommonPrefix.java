package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class CommonPrefix {


    public static String commonPrefix(String[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrays[0].length(); ++i) {
            char c = arrays[0].charAt(i);
            for (int j = 1; j < arrays.length; ++j) {
                if (i >= arrays[j].length() || arrays[j].charAt(i) != c) {
                    return sb.toString();
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
