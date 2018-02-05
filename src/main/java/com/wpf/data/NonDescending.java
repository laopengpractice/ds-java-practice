package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/14.
 */
public class NonDescending {

    public static boolean nonDescending(int[] nums) {
        int idx = -1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (idx == -1) {
                    idx = i;
                } else {
                    return false;
                }
            }
        }

        if (idx == -1) {
            return true;
        }

        int t = nums[idx];
        nums[idx] = nums[idx + 1];
        if (isAscending(nums, idx - 1, idx + 2)) {
            return true;
        }
        nums[idx] = t;
        nums[idx + 1] = t;
        if (isAscending(nums, idx - 1, idx + 2)) {
            return true;
        }

        return false;
    }

    private static boolean isAscending(int nums[], int b, int e) {
        if(b < 0) {
            b = 0;
        }
        if (e > nums.length - 1) {
            e = nums.length - 1;
        }
        for (int i = b; i < e; ++i) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(nonDescending(new int[]{2, 3, 3, 5, 3, 4}));
    }
}
