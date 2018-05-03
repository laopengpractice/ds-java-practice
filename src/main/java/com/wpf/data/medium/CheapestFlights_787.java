package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/3.
 */
public class CheapestFlights_787 {

    public static int findCheapestFlights(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[src] = 0;
        int cnt = 0;
        int min = src;
        used[min] = true;
        while(cnt <= k) {
            if (min == dst) {
                return dp[min];
            }
            for (int i = 0; i < flights.length; ++i) {
                if (flights[i][0] == min) {
                    int idx = flights[i][1];
                    int price = flights[i][2];
                    if (dp[min] + price < dp[idx]) {
                        dp[idx] = dp[min] + price;
                    }
                }
            }

            int nextMin = -1;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (used[i]) {
                    continue;
                }

                if (dp[i] < minVal) {
                    minVal = dp[i];
                    nextMin = i;
                }
            }

            min = nextMin;
            used[min] = true;
            cnt++;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    public static void main(String[] args) {
        int[][] flights = new int[3][3];
        flights[0] = new int[]{0, 1, 100};
        flights[1] = new int[]{0, 2, 500};
        flights[2] = new int[]{1, 2, 100};
        int val = findCheapestFlights(3, flights, 0, 2, 0);
        System.out.println(val);
    }
}
