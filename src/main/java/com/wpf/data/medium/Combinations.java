package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/11/23.
 */
public class Combinations {

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        if (k > n) {
            return rs;
        }
        if (k == 1) {
            for (int i = 1; i <= n; ++i) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                rs.add(list);
            }
            return rs;
        }

        List<List<Integer>> pre = combinations(n - 1, k - 1);
        rs = combinations(n - 1, k);
        for (List<Integer> l : pre) {
            l.add(n);
            rs.add(l);
        }

        return rs;
    }

    public static void main(String[] args) {
        List<List<Integer>> rs = combinations(20, 19);
        PrintUtils.printList(rs);
    }
}
