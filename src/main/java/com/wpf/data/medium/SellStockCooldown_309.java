package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/8.
 */
public class SellStockCooldown_309 {

    public static int maxProfit(int[] nums) {
        int[] hold = new int[nums.length];
        int[] unhold = new int[nums.length];
        boolean[] sell = new boolean[nums.length];

        hold[0] = -nums[0];
        unhold[0] = 0;
        for (int i = 1; i < nums.length; ++i) {
            unhold[i] = Math.max(unhold[i - 1], nums[i] + hold[i - 1]);
            if (nums[i] + hold[i - 1] > unhold[i - 1]) {
                sell[i] = true;
            }

            hold[i] = hold[i - 1];
            int curHold;
            if (sell[i - 1]) {
                curHold = unhold[i - 2] - nums[i];
            } else {
                curHold = unhold[i - 1] - nums[i];
            }
            if (hold[i] < curHold) {
                hold[i] = curHold;
            }
        }

        return unhold[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
