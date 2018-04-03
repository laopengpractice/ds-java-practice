package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/3.
 */
public class PartitionLabels763 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> rs = new ArrayList<>();
        int[] endIdx = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            endIdx[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); ++i) {
            int start = i;
            int end = endIdx[s.charAt(i) - 'a'];
            while (i < end) {
                i++;
                if (endIdx[s.charAt(i) - 'a'] <= end) {
                    continue;
                } else {
                    end = endIdx[s.charAt(i) - 'a'];
                }
            }

            rs.add(i - start + 1);
        }

        return rs;
    }

    public static void main(String[] args) {
        List<Integer> rs = partitionLabels("ababcbacadefegdehijhklij");

        PrintUtils.printList(rs);
    }
}
