package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/9/20.
 */
public class ArithSlices {

    public static int arithSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] size = new int[nums.length];
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                size[i] = size[i - 1] + 1;
            } else {
                size[i] = 0;
            }
        }

        int rs = 0;
        for (int i = 0; i < size.length; ++i) {
            if (size[i] == 0) {
                continue;
            }
            rs += size[i];
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(arithSlices(new int[]{1, 2, 3, 4}));
    }
}
