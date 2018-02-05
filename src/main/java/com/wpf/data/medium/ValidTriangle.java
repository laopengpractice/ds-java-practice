package com.wpf.data.medium;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/11/8.
 */
public class ValidTriangle {

    public static int validTriangle2(int[] nums) {
        Arrays.sort(nums);
        int rs = 0;
        int n = nums.length;
        for (int i = n - 1; i > 1; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    rs += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return rs;
    }

    public static int validTriangle(int[] nums) {
        Arrays.sort(nums);
        int rs = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int c = nums[i] + nums[j];
                int idx = bSearch(nums, j + 1, nums.length - 1, c);
                if (idx <= j || nums[idx] >= c) {
                    continue;
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
        System.out.println(validTriangle2(new int[]{24, 3, 82, 22, 35, 84, 19}));
    }
}
