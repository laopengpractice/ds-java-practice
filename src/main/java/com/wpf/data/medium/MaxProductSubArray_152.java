package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/3.
 */
public class MaxProductSubArray_152 {

    //2 3 -2 4 = 6
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int rs = 0;
        int preMax = 0;
        int preMin = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                preMax = 0;
                preMin = 0;
                continue;
            }
            if (nums[i] > 0) {
                if (preMax > 0) {
                    preMax *= nums[i];
                } else {
                    preMax = nums[i];
                }
                preMin *= nums[i];
            } else {
                int newProduct = preMin * nums[i];

                if (preMax > 0) {
                    preMin = preMax * nums[i];
                } else {
                    preMin = nums[i];
                }

                preMax = newProduct;
            }

            if (preMax > rs) {
                rs = preMax;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, -4, -1, 7, -1, 10};
        System.out.println(maxProduct(nums));
    }
}
