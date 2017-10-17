package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class BreakInteger {


    public static int breakInteger(int n) {
        int max = 1;
        for (int i = 1; i <= n / 2 + 1; ++i) {
            int l = n / i;
            int k = n % i;
            int num = (int) Math.pow(i, l);
            if (k != 0) {
                num *= k;
            }
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(breakInteger(58));
        System.out.println(System.currentTimeMillis() - start);
    }
}
