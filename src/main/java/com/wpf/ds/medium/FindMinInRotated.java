package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/11/22.
 */
public class FindMinInRotated {

    public static int findMinInRotated(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int b = 0, e = nums.length - 1;
        while (e - b > 1) {
            int mid = (e + b) / 2;
            if (nums[e] > nums[mid] && nums[mid] > nums[b]) {
                return nums[b];
            }

            if (nums[b] < nums[mid]) {
                b = mid;
            } else {
                if (nums[mid] > nums[e]) {
                    b = mid;
                } else {
                    e = mid;
                }
            }
        }

        return Math.min(nums[b], nums[e]);
    }

    public static void main(String[] args) {
        System.out.println(findMinInRotated(new int[]{3, 4, 5, 6, 1, 2}));
    }
}
