package com.wpf.data.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by wenpengfei on 2018/5/24.
 */
public class ReorganizeString_767 {

    public static String reorganize(String str) {
        int[] counter = new int[26];
        for (char c : str.toCharArray()) {
            counter[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; ++i) {
            counter[i] += i;
        }
        Arrays.sort(counter);
        int t = 0;
        char[] rs = new char[str.length()];
        for (int i = 25; i >= 0; --i) {
            char ch = (char) ((counter[i] % 100) + 'a');
            int cnt = counter[i] / 100;
            if (cnt == 0) {
                continue;
            }
            if (cnt > (str.length() + 1) / 2) {
                return "";
            }

            for (int j = 0; j < cnt; ++j) {
                if (t >= str.length()) {
                    t = 1;
                }
                rs[t] = ch;
                t += 2;
            }
        }

        return new String(rs);
    }

    static class CharCounter {
        private char ch;
        private int cnt;

        public CharCounter(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public static String reorganize2(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        PriorityQueue<CharCounter> q = new PriorityQueue<>(26,  (o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o2.ch - o1.ch;
            }
            return o2.cnt - o1.cnt;
        });
        for (int i = 0; i < 26; ++i) {
            if (counter[i] == 0) {
                continue;
            }

            q.add(new CharCounter((char) (i + 'a'), counter[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            if (q.size() >= 2) {
                CharCounter c1 = q.poll();
                CharCounter c2 = q.poll();
                sb.append(c1.ch);
                sb.append(c2.ch);
                c1.cnt--;
                c2.cnt--;
                if (c1.cnt > 0) {
                    q.add(c1);
                }
                if (c2.cnt > 0) {
                    q.add(c2);
                }
            } else {
                CharCounter c = q.poll();
                if (c.cnt > 1) {
                    return "";
                }
                sb.append(c.ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganize2("aababbc"));
    }
}
