package com.wpf.ds.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/22.
 */
public class MapSumPairs2 {

    private Map<String, Integer> prefixMap = new HashMap<>();
    private Map<String, Integer> originMap = new HashMap<>();

    public void insert(String key, int val) {
        Integer origin = originMap.get(key);
        if (origin == null) {
            origin = 0;
        }
        originMap.put(key, val);
        for (int i = 1; i <= key.length(); ++i) {
            String prefix = key.substring(0, i);
            Integer prefixVal = prefixMap.get(prefix);
            if (prefixVal == null) {
                prefixVal = 0;
            }
            prefixVal = prefixVal + val - origin;
            prefixMap.put(prefix, prefixVal);
        }
    }

    public int sum(String prefix) {
        return prefixMap.get(prefix);
    }

    public static void main(String[] args) {
        MapSumPairs2 pairs2 = new MapSumPairs2();
        pairs2.insert("apple", 12);
        pairs2.insert("app", 3);
        System.out.println(pairs2.sum("ap"));
        pairs2.insert("app", 2);
        System.out.println(pairs2.sum("app"));
    }
}
