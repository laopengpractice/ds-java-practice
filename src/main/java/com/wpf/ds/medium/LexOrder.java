package com.wpf.ds.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wenpengfei on 2017/11/8.
 */
public class LexOrder {

    public static List<Integer> lexOrder1(int n) {
        List<Integer> rs = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            rs.add(i);
        }

        Collections.sort(rs, new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });

        return rs;
    }

    public static List<Integer> lexOrder2(int n) {
        List<Integer> rs = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, rs, n);
        }

        return rs;
    }

    private static void dfs(int i, List<Integer> rs, int n) {
        if (i > n) {
            return;
        }

        rs.add(i);
        for (int j = 0; j < 10; ++j) {

        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        lexOrder2(100);
        System.out.println(System.currentTimeMillis() - start);
    }
}
