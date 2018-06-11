package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public class Subsets_78 {

    public static List<List<Integer>> subsets(List<Integer> nums) {
        if (nums.size()  == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> rs = new ArrayList<>();
        if (nums.size() == 1) {
            rs.add(new ArrayList<>());
            List<Integer> l = new ArrayList<>();
            l.add(nums.get(0));
            rs.add(l);
            return rs;
        }

        List<List<Integer>> childSets = subsets(nums.subList(1, nums.size()));

        for (List<Integer> l : childSets) {
            rs.add(l);
            List<Integer> tmp = new ArrayList<>(l);
            tmp.add(0, nums.get(0));
            rs.add(tmp);
        }

        return rs;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> rs = subsets(list);
        PrintUtils.printList(rs);
    }
}
