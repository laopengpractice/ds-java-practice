package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/29.
 */
public class TopKFrequentElements {

    static class Pair {
        int n;
        int f;

        public Pair(int n, int f) {
            this.n = n;
            this.f = f;
        }
    }

    public static int[] topKFrequency(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer f = map.get(n);
            if (f == null) {
                f = 1;
            } else {
                f++;
            }
            map.put(n, f);
        }

        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        buildHeap(pairs);

        int[] rs = new int[k];
        int i = 0;
        while (i < k) {
            rs[i] = pairs.get(0).n;
            i++;
            pairs.set(0, pairs.get(pairs.size() - 1));
            pairs.remove(pairs.size() - 1);
            adjust(pairs, 0);
        }

        return rs;
    }

    private static void buildHeap(List<Pair> pairs) {
        int nSize = pairs.size();
        for (int i = nSize / 2 - 1; i >= 0; --i) {
            adjust(pairs, i);
        }
    }

    private static void adjust(List<Pair> pairs, int j) {
        int l = j * 2 + 1;
        int cur = j;
        while (l < pairs.size()) {
            int r = l + 1;
            int max = l;
            if (r < pairs.size() && pairs.get(r).f > pairs.get(l).f) {
                max = r;
            }
            if (pairs.get(cur).f >= pairs.get(max).f) {
                break;
            }
            Pair tmp = pairs.get(cur);
            pairs.set(cur, pairs.get(max));
            pairs.set(max, tmp);
            cur = max;
            l = cur * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] rs = topKFrequency(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 4}, 1);
        PrintUtils.printInt(rs);
    }
}
