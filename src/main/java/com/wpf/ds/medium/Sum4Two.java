package com.wpf.ds.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/10/13.
 */
public class Sum4Two {

    public static int sum4Two(int[] a, int[] b, int[] c, int[] d) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        Arrays.sort(d);
        int n = a.length;
        int rs = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int k = -(a[i] + b[j]);
                int m = 0, p = n - 1;
                while (m < n && p >= 0) {
                    int sum = c[m] + d[p];
                    if (sum == k) {
                        rs++;
                        int t = m + 1;
                        while (t < n && c[t] == c[m]) {
                            rs++;
                            t++;
                        }
                        m = t;
                        t = p - 1;
                        while (t >= 0 && d[t] == d[p]) {
                            rs++;
                            t--;
                        }
                    } else if (sum > k) {
                        p--;
                    } else {
                        m++;
                    }
                }
            }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(sum4Two(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
