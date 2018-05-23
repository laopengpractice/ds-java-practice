package com.wpf.data.medium;

import java.util.HashMap;

/**
 * Created by wenpengfei on 2018/5/23.
 */
public class SplitArray_659 {

    public static boolean isPossible(int[] nums) {
        Counter counter = new Counter();
        Counter tail = new Counter();
        for (int n : nums) {
            counter.add(n, 1);
        }

        for (int n : nums) {
            if (counter.get(n) == 0) {
                continue;
            }

            if (tail.get(n - 1) > 0) {
                counter.add(n, -1);
                tail.add(n - 1, -1);
                tail.add(n, 1);
            } else if (counter.get(n + 1) > 0 && counter.get(n + 2) > 0) {
                counter.add(n, -1);
                counter.add(n + 1, -1);
                counter.add(n + 2, -1);
                tail.add(n + 2, 1);
            } else {
                return false;
            }
        }

        return true;
    }

    static class Counter {
        private HashMap<Integer, Integer> map = new HashMap<>();
        public int get(int k) {
            Integer v = map.get(k);
            return v == null ? 0 : v;
        }

        public void add(int k, int m) {
            Integer v = map.get(k);
            if (v == null) {
                v = m;
            } else {
                v += m;
            }

            map.put(k, v);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 3, 4, 5};
        System.out.println(isPossible(nums));
    }
}
