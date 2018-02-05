package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/13.
 */
public class SqrtX {

    public static int sqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int b = 1, e = x - 1;
        while (b <= e) {
            int m = ((b + e) / 2);
            if (m * m == x) {
                return m;
            } else if (m * m > x) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }

        return e;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(17));
    }

}
