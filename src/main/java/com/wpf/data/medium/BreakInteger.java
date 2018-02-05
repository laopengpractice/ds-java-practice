package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class BreakInteger {

    public static int breakInteger(int n) {
        int num3 = n / 3;
        int num2 = 0;
        if (n % 3 == 1) {
            num3--;
            num2 = 2;
        } else if (n % 3 == 2) {
            num2 = 1;
        }


        return (int)(Math.pow(3, num3) * Math.pow(2, num2));
    }

    public static void main(String[] args) {
        System.out.println(breakInteger(58));
    }
}
