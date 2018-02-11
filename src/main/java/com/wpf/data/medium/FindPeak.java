package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/2/11.
 */
public class FindPeak {

    //{1, 2, 4, 5}
    public static int findPeakLg(int[] nums) {
        int b = 0, e = nums.length - 1;

        while (b < e) {
            int m = (b + e) / 2;
            boolean left = true;
            if (m - 1 >= 0) {
                left = nums[m] > nums[m - 1];
            }
            boolean right = true;
            if (m + 1 < nums.length) {
                right = nums[m] > nums[m + 1];
            }
            if (left && right) {
                return m;
            }

            if (left) {
                b = m + 1;
            } else {
                e = m - 1;
            }
        }

        return b;
    }

    public static int findPeak(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && i < nums.length - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        System.out.println(findPeakLg(nums));
    }
}
