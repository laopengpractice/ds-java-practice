package com.wpf.data.medium;


/**
 * Created by wenpengfei on 2018/4/8.
 */
public class SellStockWithFee_714 {

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] hold = new int[prices.length];
        int[] notHold = new int[prices.length];
        notHold[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            notHold[i] = Math.max(notHold[i - 1], prices[i] + hold[i - 1] - fee);
            hold[i] = Math.max(notHold[i - 1] - prices[i], hold[i - 1]);
        }

        return notHold[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 1, 9}, 3));
    }
}
