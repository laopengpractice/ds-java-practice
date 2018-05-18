package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/5/18.
 */
public class RedundantConn_684 {

    public static int[] redundantConn(int[][] edges) {
        Map<Integer, Set<Integer>> unions = new HashMap<>();
        int n = edges.length;
        for (int i = 1; i <= n; ++i) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            unions.put(i, set);
        }

        for (int i = 0; i < n; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            Set<Integer> set1 = unions.get(u);
            Set<Integer> set2 = unions.get(v);
            if (set1 == set2) {
                return edges[i];
            }

            set1.addAll(set2);
            for (Integer k : set2) {
                unions.put(k, set1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[] rs = redundantConn(edges);
        PrintUtils.printInt(rs);
    }
}
