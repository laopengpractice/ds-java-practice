package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenpengfei on 2018/2/11.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (String word : words) {
            char[] cs = word.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> list = wordMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                wordMap.put(key, list);
            }
            list.add(word);
        }
        List<List<String>> rs = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : wordMap.entrySet()) {
            rs.add(entry.getValue());
        }

        return rs;
    }

    public static void main(String[] args) {
        String[] input = {"eat", "ate", "aet", "bat", "tby", "ytb"};
        List<List<String>> rs = groupAnagrams(input);
        PrintUtils.printList(rs);
    }
}
