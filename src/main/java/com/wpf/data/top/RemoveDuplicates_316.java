package com.wpf.data.top;

/**
 * Created by wenpengfei on 2018/5/30.
 */
public class RemoveDuplicates_316 {

    public static String removeDuplicates(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        boolean[] use = new boolean[26];
        char[] rs = new char[26];
        int end = 0;
        //cbaba
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            cnt[idx]--;
            if (use[idx]) {
                continue;
            }
            int pos = 0;
            for (int j = end - 1; j >= 0; --j) {
                if (cnt[rs[j] - 'a'] == 0 || rs[j] <= s.charAt(i)) {
                    pos = j + 1;
                    break;
                }
                use[rs[j] - 'a'] = false;
            }
            rs[pos] = s.charAt(i);
            use[idx] = true;
            end = pos + 1;
        }

        return new String(rs, 0, end);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("acbaaac"));
    }
}
