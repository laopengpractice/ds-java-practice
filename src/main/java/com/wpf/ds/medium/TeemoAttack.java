package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/9/27.
 */
public class TeemoAttack {

    public static int teemoAttack(int[] p, int duration) {
        if (p == null || p.length == 0) {
            return 0;
        }
        int start = p[0], end = p[0] + duration - 1;
        int rs = 0;
        for (int i = 1; i < p.length; ++i) {
            if (p[i] > end) {
                rs += end - start + 1;
                start = p[i];
                end = start + duration - 1;
            } else {
                end = p[i] + duration - 1;
            }
        }

        return rs + end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(teemoAttack(new int[]{1, 2, 3, 4, 10}, 2));
    }
}
