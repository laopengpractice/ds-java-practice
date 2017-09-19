package com.wpf.ds;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class Heaters {


    public static int heaters(int[] pos, int[] heaters) {
        int rs = 0;
        int i = 0, j = 0;
        Arrays.sort(pos);
        Arrays.sort(heaters);
        while (j < pos.length) {
            int dis = Math.abs(pos[j] - heaters[i]);
            i++;
            while (i < heaters.length && Math.abs(pos[j] - heaters[i]) <= dis) {
                dis = Math.abs(pos[j] - heaters[i]);
                i++;
            }
            if (rs < dis) {
                rs = dis;
            }

            i--;
            j++;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(heaters(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 10002}));
    }
}
