package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/11.
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int rs = 0;
        for (int i = 0; i < 32; ++i) {
            int num = n & 1;
            rs = rs * 2 + num;
            n >>>= 1;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-2147483648));
    }
}
