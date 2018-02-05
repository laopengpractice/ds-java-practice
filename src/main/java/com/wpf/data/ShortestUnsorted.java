package com.wpf.data;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/9/11.
 */
public class ShortestUnsorted {

    public static int shortestUnsorted(int[] nums) {
        int[] num2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(num2);
        int start = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (num2[i] != nums[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }

        int end = -1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (num2[i] != nums[i]) {
                end = i;
                break;
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(shortestUnsorted(new int[]{5, 4, 3, 2, 1}));
    }
}
