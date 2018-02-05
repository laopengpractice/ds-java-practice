package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class SquareSum {

    public static boolean squareSum(int sum) {
        int sqrt = (int) Math.sqrt(sum);
        int i = 1, j = sqrt;
        while (i <= j) {
            int n = i * i + j * j;
            if (n == sum) {
                return true;
            } else if (n < sum) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(squareSum(2));
    }
}
