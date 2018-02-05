package com.wpf.data.medium;

import com.wpf.data.common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/22.
 */
public class MostFrequentSubtreeSum {

    private static int max;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static List<Integer> mostFrequent(TreeNode root) {
        dfs(root);
        List<Integer> rs = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                rs = new ArrayList<>();
                rs.add(entry.getKey());
            } else if (entry.getValue() == max) {
                rs.add(entry.getKey());
            }
        }

        return rs;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        Integer num = map.get(sum);
        if (num == null) {
            num = 0;
        }
        num++;
        map.put(sum, num);
        return sum;
    }
}
