package com.wpf.data;

/**
 * Created by wenpengfei on 2017/10/25.
 */
public class KnapsackProblem {


    public static int knapsackProblem01(int[] sizes, int[] vals, int bagSize) {
        int[][] dp = new int[sizes.length + 1][];
        for (int i = 0; i <= sizes.length; ++i) {
            dp[i] = new int[bagSize + 1];
        }
        for (int i = 0; i <= bagSize; ++i) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= sizes.length; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= sizes.length; ++i) {
            for (int j = 1; j <= bagSize; ++j) {
                if (j < sizes[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - sizes[i - 1]] + vals[i - 1]);
                }
            }
        }

        return dp[sizes.length][bagSize];
    }

    private static void qsort(int[] idx, int[] sizes, int[] vals, int b, int e) {
        if (b >= e) {
            return;
        }

        int m = b - 1;
        int n = e;
        double pivot = vals[n] / (double)sizes[n];
        for (int i = b; i < n; ++i) {
            int index = idx[i];
            double weight = vals[index] / (double)sizes[index];
            if (weight > pivot) {
                m++;
                if (m != i) {
                    swap(idx, i, m);
                }
            } else if (weight < pivot) {
                n--;
                if (n != i) {
                    swap(idx, i, n);
                }
                --i;
            }
        }
        if (n != e) {
            swap(idx, n, e);
        }
        n++;

        qsort(idx, sizes, vals, b, m);
        qsort(idx, sizes, vals, n, e);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static int knapSackProblemGreedy(int[] sizes, int[] vals, int bagSize) {
        int[] idx = new int[sizes.length];
        for (int i = 0; i < sizes.length; ++i) {
            idx[i] = i;
        }

        qsort(idx, sizes, vals, 0, sizes.length - 1);
        int rs = 0;
        int i = 0;
        while (bagSize > 0 && i < sizes.length) {
            int index = idx[i];
            int size = sizes[index];
            if (size > bagSize) {
                size = bagSize;
                rs += size * (vals[index] / (double)sizes[index]);
            } else {
                rs += vals[index];
            }
            bagSize -= size;
            i++;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] sizes = new int[]{2, 3, 3, 6};
        int[] vals = new int[]{2, 4 , 5, 8};
        System.out.println(knapsackProblem01(sizes, vals, 8));
    }
}
