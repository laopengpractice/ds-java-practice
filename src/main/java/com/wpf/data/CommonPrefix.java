package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class CommonPrefix {

    public static String commonPrefix(String[] arrays) {
        if (arrays.length == 0) {
            return "";
        }
        int min = 0;
        for (int i = 1; i < arrays.length; ++i) {
            if (arrays[i].length() < arrays[min].length()) {
                min = i;
            }
        }

        String prefix = arrays[min];
        for (int i = 0; i < arrays.length; ++i) {
            if (i == min) {
                continue;
            }
            for (int j = 0; j < prefix.length(); ++j) {
                if (prefix.charAt(j) != arrays[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }
}
