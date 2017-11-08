package com.wpf.ds.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/11/8.
 */
public class ValidTriangle {

    public static int validTriangle(int[] nums) {
        Arrays.sort(nums);
        int rs = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int c = nums[i] + nums[j];
                int idx = bSearch(nums, j + 1, nums.length - 1, c);
                if (idx <= j || nums[idx] >= c) {
                    break;
                }
                rs += idx - j;
            }
        }

        return rs;
    }

    public static int bSearch(int[] nums, int b, int e, int n) {
        while (b <= e) {
            int m = (b + e) / 2;
            if (nums[m] == n) {
                return m - 1;
            } else if (nums[m] > n) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }

        return e;
    }

    public static void main(String[] args) {
        System.out.println(validTriangle(new int[]{1, 2, 2, 3, 4}));
    }
}
