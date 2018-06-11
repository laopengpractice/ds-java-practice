package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public class MostSorted_769 {

    //1 0 4 3 5 2 6
    public static int mostSorted(int[] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length; ++i) {
            int e = nums[i];
            i++;
            while (i <= e) {
                if (nums[i] > e) {
                    e = nums[i];
                }
                i++;
            }
            rs++;
            i--;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = {0, 5, 4, 3, 2, 1};
        System.out.println(mostSorted(nums));
    }
}
