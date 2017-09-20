package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/9/20.
 */
public class SingleElement {

    public static int singleElement(int[] nums) {
        int b = 0;
        int e = nums.length - 1;
        while (b < e) {
            int m = (b + e) / 2;
            if (nums[m] == nums[m - 1]) {
                if ((m - b + 1) % 2 == 0) {
                    b = m + 1;
                } else {
                    e = m - 2;
                }
            } else if (nums[m] == nums[m + 1]) {
                if ((m - b + 1) % 2 == 0) {
                    e = m - 1;
                } else {
                    b = m + 2;
                }
            } else {
                return nums[m];
            }
        }

        return nums[b];
    }

    public static void main(String[] args) {
        System.out.println(singleElement(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
}
