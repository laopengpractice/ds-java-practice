package com.wpf.ds.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/11/6.
 */
public class TargetSum {

    public static int targetSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums[0] == 0) {
            map.put(nums[0], 2);
        } else {
            map.put(nums[0], 1);
            map.put(-nums[0], 1);
        }

        for (int i = 1; i < nums.length; ++i) {
            HashMap<Integer, Integer> cur = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int ratio = -1;
                for (int j = 0; j < 2; ++j) {
                    ratio *= -1;
                    int key = entry.getKey() + ratio * nums[i];
                    if (cur.containsKey(key)) {
                        cur.put(key, cur.get(key) + entry.getValue());
                    } else {
                        cur.put(key, entry.getValue());
                    }
                }
            }
            map = cur;
        }

        return map.get(target);
    }

    public static void main(String[] args) {
        System.out.println(targetSum(new int[]{1, 1, 1, 1, 1}, 5));
    }
}
