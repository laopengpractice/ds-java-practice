package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/11.
 */
public class PlantFlower {

    public static boolean plantFlower(int[] bed, int n) {

        int size = 0;
        for (int i = 0; i < bed.length; ++i) {
            int start = i;
            while (i < bed.length && bed[i] == 0) {
                i++;
            }
            int num = i - start;
            if (num <= 1) {
                continue;
            }
            if (start > 0 && bed[start - 1] == 1) {
                num--;
            }
            if (i < bed.length && bed[i] == 1) {
                num--;
            }
            if (num > 0) {
                size += (num + 1) / 2;
            }
        }

        return size >= n;
    }

    public static void main(String[] args) {
        int i = 0;
        int j = ~i;
        System.out.println(j);
    }
}
