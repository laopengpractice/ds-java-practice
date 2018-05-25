package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/25.
 */
public class JumpGame_55 {

    //3 2 1 1 4
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int start = 1;
        int end = nums[0];
        while (start <= end) {
            int tmp = end;
            for (int j = start; j <= end; ++j) {
                if (j + nums[j] > tmp) {
                    tmp = j + nums[j];
                    if (tmp >= nums.length - 1) {
                        return true;
                    }
                }
            }

            start = end + 1;
            end = tmp;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
