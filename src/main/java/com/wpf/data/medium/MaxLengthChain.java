package com.wpf.data.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wenpengfei on 2017/9/30.
 */
public class MaxLengthChain {

    public static int maxLengthChain1(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] rs = new int[pairs.length];
        rs[0] = 1;
        int max = 1;
        for (int i = 1; i < pairs.length; ++i) {
            int curMax = 1;
            for (int j = 0 ; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0] && rs[j] + 1 > curMax) {
                    curMax = rs[j] + 1;
                }
            }
            rs[i] = curMax;
            if (curMax > max) {
                max = curMax;
            }
        }

        return max;
    }

    public static int maxLengthChain2(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int rs = 1;
        int curEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; ++i) {
            if (pairs[i][0] > curEnd) {
                rs++;
                curEnd = pairs[i][1];
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{1, 2};
        a[1] = new int[]{2, 3};
        a[2] = new int[]{3, 4};
        System.out.println(maxLengthChain2(a));
    }
}
