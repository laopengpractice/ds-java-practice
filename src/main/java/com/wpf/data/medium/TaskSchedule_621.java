package com.wpf.data.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2018/5/22.
 */
public class TaskSchedule_621 {

    public static int interval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] cnts = new int[26];
        for (char c : tasks) {
            cnts[c - 'A']++;
        }
        Arrays.sort(cnts);
        int size = tasks.length;
        int rs = 0;
        while (size > 0) {
            int cnt = 0;
            for (int j = 25; j >= 0; --j) {
                if (cnts[j] > 0) {
                    cnts[j]--;
                    cnt++;
                    if (cnt == n + 1) {
                        break;
                    }
                }
            }

            size -= cnt;

            if (cnt < n + 1 && size > 0) {
                cnt = n + 1;
            }

            rs += cnt;
            Arrays.sort(cnts);
        }

        return rs;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'B', 'A', 'B', 'A', 'B'};
        System.out.println(interval(tasks, 2));
    }
}
