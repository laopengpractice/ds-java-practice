package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/5/28.
 */
public class SplitArrayFibonacci_842 {

    public static List<Integer> split(String s) {
        if (s.length() < 3) {
            return new ArrayList<>();
        }
        for (int i = 1; i <= s.length() - 2; ++i) {
            int first = Integer.parseInt(s.substring(0, i));
            for (int j = i + 1; j <= s.length() - 1; ++j) {
                int second = Integer.parseInt(s.substring(i, j));
                List<Integer> rs = new ArrayList<>();
                rs.add(first);
                rs.add(second);
                boolean succ = true;
                for (int k = j; k < s.length(); ++k) {
                    int sum = first + second;
                    int tmp = 0;
                    while (k < s.length() && tmp < sum) {
                        tmp = tmp * 10 + (s.charAt(k) - '0');
                        k++;
                    }
                    if (tmp == sum) {
                        first = second;
                        second = sum;
                        rs.add(sum);
                        k--;
                    } else {
                        succ = false;
                        break;
                    }
                }

                if (succ) {
                    return rs;
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> nums = split("123151833");
        PrintUtils.printList(nums);
    }
}
