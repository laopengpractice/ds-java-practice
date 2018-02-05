package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class CountPrime {

    public static int countPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt + 1; ++i) {
            if (prime[i]) {
                continue;
            }
            for (int j = i; j <= n / i; ++j) {
                prime[i * j] = true;
            }
        }

        int c = 0;
        for (int i = 1; i <= n; ++i) {
            if (!prime[i]) {
                c++;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(countPrime(17));
    }
}
