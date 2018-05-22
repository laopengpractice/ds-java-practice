package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/5/22.
 */
public class PartLabels_763 {

    public static List<Integer> partLabels(String s) {
        int[] idx = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            idx[c - 'a'] = i;
        }

        List<Integer> rs = new ArrayList<>();
        int end = -1;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            int endIdx = idx[s.charAt(i) - 'a'];
            if (end == -1) {
                end = endIdx;
            }

            if (i == end) {
                rs.add(i - start + 1);
                start = i + 1;
                end = -1;
                continue;
            }

            if (endIdx > end) {
                end = endIdx;
            }

        }

        return rs;
    }

    public static void main(String[] args) {
        List<Integer> rs = partLabels("abcdefg");
        PrintUtils.printList(rs);
    }
}
