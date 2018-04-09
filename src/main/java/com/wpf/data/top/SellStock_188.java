package com.wpf.data.top;

/**
 * Created by wenpengfei on 2018/4/9.
 */
public class SellStock_188 {

    public static int maxProfit(int k, int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] hold = new int[k];
        int[] sell = new int[k];

        hold[0] = -nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = k - 1; j >= 0; --j) {
                sell[j] = Math.max(sell[j], nums[i] + hold[j]);
                hold[j] = Math.max(hold[j], j == 0 ? 0 : sell[j - 1] - nums[i]);
                max = Math.max(max, sell[j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 5, 3, 6, 4, 19};
        System.out.println(maxProfit(2, nums));
    }
}
