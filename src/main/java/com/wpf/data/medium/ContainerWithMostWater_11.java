package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/6/14.
 */
public class ContainerWithMostWater_11 {

    public static int containerMostWater(int[] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i; j < nums.length; ++j) {
                int area = (j - i + 1) * Math.min(nums[i], nums[j]);
                if (rs < area) {
                    rs = area;
                }
            }
        }

        return rs;
    }

    //3 2 1 5 10 5 4 2
    public static int mostWater2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        int rs = nums[i];
        while (i <= j) {
            int area = (j - i + 1) * Math.min(nums[i], nums[j]);
            if (area > rs) {
                rs = area;
            }

            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 5, 10, 5, 4, 3};
        System.out.println(mostWater2(nums));
    }
}
