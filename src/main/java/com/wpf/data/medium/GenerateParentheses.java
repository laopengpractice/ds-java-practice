package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/26.
 */
public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        char[] str = new char[n * 2];
        List<String> rs = new ArrayList<>();
        help(str, 0, n, n, rs);

        return rs;
    }

    private static void help(char[] str, int idx, int left, int right, List<String> rs) {
        if (idx == str.length) {
            rs.add(new String(str));
            return;
        }

        if (left > 0) {
            str[idx] = '(';
            help(str, idx + 1, left-1, right, rs);
        }

        if (left < right && right > 0) {
            str[idx] = ')';
            help(str, idx + 1, left, right-1, rs);
        }
    }

    public static void main(String[] args) {
        List<String> rs = generateParentheses(4);
        PrintUtils.printList(rs);
    }
}
