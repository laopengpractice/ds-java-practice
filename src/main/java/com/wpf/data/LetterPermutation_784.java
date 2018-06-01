package com.wpf.data;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/5/31.
 */
public class LetterPermutation_784 {

    public static List<String> letterPermutation(String s) {
        return null;
    }

    private static List<String> help(String s, int b) {
        List<String> rs = new ArrayList<>();
        if (b >= s.length()) {
            rs.add("");
            return rs;
        }

        List<String> olds = help(s, b + 1);
        char c = s.charAt(b);
        olds.forEach(str -> rs.add(c + str));
        if (Character.isAlphabetic(c)) {
            if (Character.isLowerCase(c)) {
                char up = Character.toUpperCase(c);
                olds.forEach(str -> rs.add(up + str));
            } else {
                char low = Character.toLowerCase(c);
                olds.forEach(str -> rs.add(low + str));
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        List<String> rs = letterPermutation("s1a2d4");
        PrintUtils.printList(rs);
    }
}
