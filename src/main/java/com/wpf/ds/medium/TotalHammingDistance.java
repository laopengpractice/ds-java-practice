package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/10/13.
 */
public class TotalHammingDistance {

    public static int totalHammingDistance(int[] nums) {
        int rs = 0;
        for (int i = 0; i < 32; ++i) {
            int k = 0;
            for (int n : nums) {
                if ((n & (1 << i)) != 0) {
                    k++;
                }
            }

            rs += k * (nums.length - k);
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 14};
        System.out.println(totalHammingDistance(nums));
    }
}
