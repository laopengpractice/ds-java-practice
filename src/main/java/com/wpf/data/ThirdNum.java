package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/13.
 */
public class ThirdNum {


    public static int thirdMaxNum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Integer f = nums[0], s = null, t = null;
        for (int n :nums) {
            if (n == f) {
                continue;
            } else if (n > f) {
                t = s;
                s = f;
                f = n;
            } else {
                if(s == null || n > s) {
                    t = s;
                    s = n;
                } else if (n != s && (t == null || n > t)) {
                    t = n;
                }
            }
        }

        return t == null ? f : t;
    }

    public static void main(String[] args) {
        System.out.println(thirdMaxNum(new int[]{3, 2, 2, 1}));
    }
}
