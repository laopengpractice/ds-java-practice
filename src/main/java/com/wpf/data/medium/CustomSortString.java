package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/3.
 */
public class CustomSortString {

    public static String customSortString(String s, String t) {
        boolean[] found = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            found[s.charAt(i) - 'a'] = true;
        }

        int[] nums = new int[26];
        for (char c : t.toCharArray()) {
            nums[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < nums[s.charAt(i) - 'a']; ++j) {
                sb.append(s.charAt(i));
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (found[i]) {
                continue;
            }

            for (int j = 0; j < nums[i]; ++j) {
                sb.append((char) (i + 'a'));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("dbca", "abcdefgabc"));
    }
}
