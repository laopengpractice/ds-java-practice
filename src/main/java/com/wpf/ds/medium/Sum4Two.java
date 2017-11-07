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
                        int t1 = m + 1;
                        while (t1 < n && c[t1] == c[m]) {
                            t1++;
                        }
                        int t2 = p - 1;
                        while (t2 >= 0 && d[t2] == d[p]) {
                            t2--;
                        }

                        rs += (t1 - m) * (p - t2);
                        m = t1;
                        p = t2;
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
        System.out.println(sum4Two(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}));
    }
}
