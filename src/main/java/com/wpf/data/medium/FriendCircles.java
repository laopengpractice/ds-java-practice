package com.wpf.data.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wenpengfei on 2017/9/29.
 */
public class FriendCircles {

    public static int friendCirclesDfs(int[][] m) {
        if (m.length == 0) {
            return 0;
        }
        int rs = 0;
        boolean[] v = new boolean[m.length];
        for (int i = 0; i < m.length; ++i) {
            if (!v[i]) {
                rs++;
                v[i] = true;
                bfs(m, i, v);
            }
        }

        return rs;
    }

    private static void dfs(int[][] m, int i, boolean[] v) {
        for (int j = 0; j < m[i].length; ++j) {
            if (m[i][j] == 1 && !v[j]) {
                v[j] = true;
                dfs(m, j, v);
            }
        }
    }

    private static void bfs(int[][] m, int i, boolean[] v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int j = 0; j < m[q].length; ++j) {
                if (m[q][j] == 1 && !v[j]) {
                    v[j] = true;
                    queue.add(j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] m = new int[3][];
        for (int i = 0; i < 3; ++i) {
            m[i] = new int[3];
        }
        m[0][0] = 1;
        m[0][1] = 1;
        m[1][1] = 1;
        m[1][0] = 1;
        m[2][2] = 1;
        System.out.println(friendCirclesDfs(m));
    }
}
