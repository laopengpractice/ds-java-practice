package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/11/17.
 */
public class GrayCode {

    public static List<Integer> grayCodeDfs(int n) {
        List<Integer> rs = new ArrayList<>();
        if (n < 1) {
            return rs;
        }
        if (n == 1) {
            rs.add(0);
            rs.add(1);
            return rs;
        }

        rs = grayCodeDfs(n - 1);
        for (int i = rs.size() - 1; i >= 0; --i) {
            int num = rs.get(i) | (1 << (n - 1));
            rs.add(num);
        }

        return rs;
    }

    public static List<Integer> grayCodeBfs(int n) {
        List<Integer> rs = new ArrayList<>();
        if (n < 1) {
            return rs;
        }
        rs.add(0);
        rs.add(1);
        int k = 1;
        while (k < n) {
            for (int i = rs.size() - 1; i >= 0; --i) {
                int num = (rs.get(i) | (1 << k));
                rs.add(num);
            }
            k++;
        }

        return rs;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> rs = grayCodeBfs(20);
        System.out.println(rs.size() + " " + (System.currentTimeMillis() - start));
    }
}
