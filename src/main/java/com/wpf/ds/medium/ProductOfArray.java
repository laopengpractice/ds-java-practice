package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;

/**
 * Created by wenpengfei on 2017/9/29.
 */
public class ProductOfArray {

    public static int[] productOfArray1(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int[] begin = new int[nums.length];
        begin[0] = 1;
        int[] end = new int[nums.length];
        end[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            begin[i] = begin[i - 1] * nums[i - 1];
            end[nums.length - i - 1] = end[nums.length - i] * nums[nums.length - i];
        }

        int[] rs = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            rs[i] = begin[i] * end[i];
        }

        return rs;
    }

    public static int[] productOfArray2(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] rs = new int[n];
        rs[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rs[i] = rs[i + 1] * nums[i + 1];
        }
        int c = 1;
        for (int i = 0; i < n; ++i) {
            rs[i] *= c;
            c *= nums[i];
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] rs = productOfArray2(new int[]{1, 2, 3, 4, 5});
        PrintUtils.printInt(rs);
    }
}
