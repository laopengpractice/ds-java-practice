package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class Heaters {


    public static int heaters(int[] pos, int[] heaters) {
        int rs = 0;
        int i = 0, j = 0;
        while (j < pos.length) {
            int dis = pos[j] - heaters[i];
            if (dis < 0) {
                if (rs < Math.abs(dis)) {
                    rs = Math.abs(dis);
                }
            } else if(dis > 0) {
                i++;
                while (i < heaters.length && Math.abs(pos[j] - heaters[i]) < dis) {
                    dis = Math.abs(pos[j] - heaters[i]);
                    i++;
                }
                if (rs < dis) {
                    rs = dis;
                }
                i--;
            }

            j++;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(heaters(new int[]{1, 2, 10000, 10004}, new int[]{2, 10002}));
    }
}
