package com.wpf.ds.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wenpengfei on 2017/9/20.
 */
public class QueueReconstruct {

    static class Pair {
        int h;
        int k;

        public Pair(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }

    public static List<Pair> queueReconstruct(List<Pair> queues) {
        int[] nums = new int[queues.size()];
        Collections.sort(queues, new Comparator<Pair>() {
            @Override public int compare(Pair o1, Pair o2) {
                return o1.h == o2.h ? Integer.compare(o1.k, o2.k) : Integer.compare(o1.h, o2.h);
            }
        });
        List<Pair> rs = new ArrayList<>();
        for (int i = 0; i < queues.size(); ++i) {
            int min = -1;
            for (int j = 0; j < queues.size(); ++j) {
                if (queues.get(j).k == nums[j]) {
                    min = j;
                    break;
                }
            }
            rs.add(queues.get(min));
            for (int j = 0; j < queues.size(); ++j) {
                if (queues.get(j).h > queues.get(min).h) {
                    break;
                }
                nums[j]++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        List<Pair> queues = new ArrayList<>();
        queues.add(new Pair(7, 0));
        queues.add(new Pair(4, 4));
        queues.add(new Pair(7, 1));
        queues.add(new Pair(5, 0));
        queues.add(new Pair(6, 1));
        queues.add(new Pair(5, 2));
        List<Pair> rs = queueReconstruct(queues);
        for (Pair p : rs) {
            System.out.println(p.h + " " + p.k);
        }
    }
}
