package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/30.
 */
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum(int k, int n) {
        Integer[] l = new Integer[k];
        List<List<Integer>> rs = new ArrayList<>();
        help(k, n, 1, l, rs);
        return rs;
    }

    private static void help(int k, int n, int begin, Integer[] l, List<List<Integer>> rs) {
        if (k == 1) {
            if (n >= begin && n <= 9) {
                l[l.length - k] = n;
                List<Integer> list = new ArrayList<>();
                for (int item : l) {
                    list.add(item);
                }
                rs.add(list);
            }
            return;
        }
        if (begin > 9) {
            return;
        }
        for (int i = begin; i <= 9 && i <= n; ++i) {
            l[l.length - k] = i;
            help(k - 1, n - i, i + 1, l, rs);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rs = combinationSum(3, 12);
        for (List<Integer> list : rs) {
            PrintUtils.printList(list);
        }
    }
}
