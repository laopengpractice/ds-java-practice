package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

/**
 * Created by wenpengfei on 2018/6/5.
 */
public class BeautifulArrange2_667 {

    //1 2 3 5 4
    public static int[] buildArrange(int n, int k) {
        int[] rs = new int[n];
        int t = 1;
        for (int i = 0; i < n - k - 1; ++i) {
            rs[i] = t++;
        }

        int e = n;
        boolean b = true;
        for (int i = n - k - 1; i < n; ++i) {
            if (b) {
                rs[i] = t++;
            } else {
                rs[i] = e--;
            }
            b = !b;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] rs = buildArrange(5, 4);
        PrintUtils.printInt(rs);
    }
}
