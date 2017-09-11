package com.wpf.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/9/4.
 */
public class PatternIndex {

    private static int[] patternIndex(String a, String b) {
        if (b.length() > a.length() || b.isEmpty()) {
            return new int[]{};
        }
        List<Integer> rs = new ArrayList<>();
        int count = b.length();
        int[] cnt = new int[26];
        boolean[] need = new boolean[26];
        for (char c : b.toCharArray()) {
            cnt[c - 'a']++;
            need[c - 'a'] = true;
        }
        for (int i = 0; i < a.length(); ++i) {
            char c = a.charAt(i);
            if (i >= b.length())  {
                char last = a.charAt(i - b.length());
                if (need[last - 'a']) {
                    if (cnt[last - 'a'] >= 0) {
                        count++;
                    }
                    cnt[last - 'a']++;
                }
            }
            if (need[c - 'a']) {
                if (cnt[c - 'a'] > 0) {
                    count--;
                }
                cnt[c - 'a']--;
            }
            if (count == 0) {
                rs.add(i - b.length() + 1);
            }
        }

        int[] result = new int[rs.size()];
        for (int i = 0; i < rs.size(); ++i) {
            result[i] = rs.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "abcaaccacacadcdea";
        String b = "aac";
        int[] rs = patternIndex(a, b);
        for (int n : rs) {
            System.out.println(n);
        }
    }
}
