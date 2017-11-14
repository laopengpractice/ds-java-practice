package com.wpf.ds.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wenpengfei on 2017/11/14.
 */
public class MinBurstBallons {

    public static int minBurstBallons(int[][] ballons) {
        Arrays.sort(ballons, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }

                return Integer.compare(o1[0], o2[0]);
            }
        });

        int rs = 0;
        int i = 0;
        while (i < ballons.length) {
            int start = i;
            rs++;
            i++;
            while (i < ballons.length && intersect(ballons[start], ballons[i])) {
                i++;
            }
        }

        return rs;
    }

    private static boolean intersect(int[] o1, int[] o2) {
        if (o1[1] > o2[0]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] ballons = new int[4][];
        ballons[0] = new int[]{10, 16};
        ballons[1] = new int[]{2, 8};
        ballons[2] = new int[]{1, 6};
        ballons[3] = new int[]{7, 12};
        System.out.println(minBurstBallons(ballons));
    }
}
