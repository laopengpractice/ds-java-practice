package com.wpf.data.medium;

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
            int[] tmp = ballons[start];
            while (i < ballons.length) {
                tmp = intersect(tmp, ballons[i]);
                if (tmp == null) {
                    break;
                }
                i++;
            }
        }

        return rs;
    }

    private static int[] intersect(int[] o1, int[] o2) {
        if (o1[1] < o2[0]) {
            return null;
        }

        int[] rs = new int[2];
        rs[0] = o2[0];
        rs[1] = Math.min(o1[1], o2[1]);

        return rs;
    }

    public static void main(String[] args) {
        int[][] ballons = new int[7][];
        ballons[0] = new int[]{9, 12};
        ballons[1] = new int[]{1, 10};
        ballons[2] = new int[]{4, 11};
        ballons[3] = new int[]{8, 12};
        ballons[4] = new int[]{3, 9};
        ballons[5] = new int[]{6, 9};
        ballons[6] = new int[]{6, 7};
        System.out.println(minBurstBallons(ballons));
    }
}
