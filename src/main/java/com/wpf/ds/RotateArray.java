package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class RotateArray {

    public static void rotateArray(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        rotateArray(nums, 0, nums.length - k - 1);
        rotateArray(nums, nums.length - k, nums.length - 1);
        rotateArray(nums, 0, nums.length - 1);
    }

    private static void rotateArray(int[] nums, int b, int e) {
        for (int i = b, j = e; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray(nums, 3);
        for (int i  : nums) {
            System.out.println(i);
        }
    }
}
