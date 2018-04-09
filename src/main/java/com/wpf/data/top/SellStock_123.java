package com.wpf.data.top;

/**
 * Created by wenpengfei on 2018/4/8.
 */
public class SellStock_123 {

    public static int maxProfit2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int hold1 = -nums[0], hold2 = 0;
        int sell1 = 0, sell2 = 0;
        for (int i = 1; i < nums.length; ++i) {
            sell2 = Math.max(sell2, hold2 + nums[i]);
            hold2 = Math.max(hold2, sell1 - nums[i]);
            sell1 = Math.max(sell1, nums[i] + hold1);
            hold1 = Math.max(hold1, -nums[i]);
        }

        return Math.max(sell1, sell2);
    }

    public static int maxProfit(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] profit1 = profit1(nums);
        //max profit only transaction one
        int max = 0;
        for (int i : profit1) {
            if (max < i) {
                max = i;
            }
        }

        int high = nums[nums.length - 1];
        int low = high;
        int profit = 0;
        for (int i = nums.length - 2; i >= 1; --i) {
            if (nums[i] > high) {
                high = nums[i];
                low = high;
            } else {
                if (nums[i] < low) {
                    low = nums[i];
                }
            }

            if (profit < high - low) {
                profit = high - low;
            }

            if (profit1[i - 1] + profit > max) {
                max = profit + profit1[i - 1];
            }
        }

        return max;
    }

    private static int[] profit1(int[] nums) {
        int min = nums[0];
        int[] profit = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
            profit[i] = nums[i] - min;
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 5, 3, 6, 4, 19};
        System.out.println(maxProfit2(nums));
    }
}
