package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/25.
 */
public class GasStation_134 {

    //1 2 3 4 5 //3 4 5 1 2
    public static int gasStation(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remain = new int[n];
        for (int i = 0; i < n; ++i) {
            remain[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < n; ++i) {
            if (remain[i] < 0) {
                continue;
            }

            // 1 2 1 2
            int amount = remain[i];
            int j = (i + 1) % n;
            while (amount >= 0 && j != i) {
                amount += remain[j];
                j = (j + 1) % n;
            }

            if (amount < 0) {
                i = Math.max((j + n - 1) % n, i);
            } else if (j == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(gasStation(gas, cost));
    }
}
