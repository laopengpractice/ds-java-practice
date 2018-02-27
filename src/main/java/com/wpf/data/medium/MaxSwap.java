package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/2/27.
 */
public class MaxSwap {

    public static int maxSwap(int num) {
        List<Integer> ns = new ArrayList<>();
        while (num != 0) {
            ns.add(num % 10);
            num /= 10;
        }

        for (int i = ns.size() - 1; i >= 0; --i) {
            int max = ns.get(i) + 1;
            int idx = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (ns.get(j) >= max) {
                    idx = j;
                }
            }

            if (idx != -1) {
                swap(ns, i, idx);
                break;
            }
        }

        int rs = 0;
        for (int i = ns.size() - 1; i >= 0; --i) {
            rs = rs * 10 + ns.get(i);
        }

        return rs;
    }

    private static void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }

    public static void main(String[] args) {
        int num = maxSwap(912991);
        System.out.println(num);
    }
}
