package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class NDigit {

    public static int nDigit(int n) {
        int k = 1;
        int e = 9;
        int sum = k * e;
        int pre = 0;
        while (sum < n) {
            k++;
            e *= 10;
            pre = sum;
            sum += k * e;
        }
        n -= pre;
        int num = (n - 1) / k;
        e = 1;
        int newK = k;
        while (newK > 1) {
            e *= 10;
            newK--;
        }
        int theNum = e + num;
        int kth = n - num * k;
        newK = k - kth;
        e = 1;
        while (newK > 0) {
            e *= 10;
            newK--;
        }

        return (theNum / e) % 10;
    }

    public static void main(String[] args) {
        System.out.println(nDigit(15));
    }
}
