package com.wpf.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/11.
 */
public class ReverseBits {

    private static Map<Integer, Integer> byteMap = new HashMap<>();

    public static int reverseBits(int n) {
        int rs = 0;
        for (int i = 0; i < 32; ++i) {
            int num = n & 1;
            rs <<= 1;
            rs +=  num;
            n >>>= 1;
        }

        return rs;
    }

    public static int reverseBits2(int n) {
        int rs = 0;
        for (int i = 0; i < 4; ++i) {
            rs <<= 8;
            int num = n & 0xFF;
            rs += getByte(num);
            n >>>= 8;
        }

        return rs;
    }

    private static int getByte(int b) {
        Integer rs = byteMap.get(b);
        if (rs != null) {
            return rs;
        }

        rs = 0;
        for (int i = 0; i < 8; ++i) {
            rs <<= 1;
            int n = b & 1;
            rs += n;
            b >>>= 1;
        }

        byteMap.put(b, rs);

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits2(Integer.MIN_VALUE));
    }
}
