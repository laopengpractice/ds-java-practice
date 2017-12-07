package com.wpf.ds.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wenpengfei on 2017/11/17.
 */
public class EvalDivision {

    public static double[] calcEq(String[][] eqs, double[] vals, String[][] queries) {
        Map<String, Map<String, Double>> graphMap = new HashMap<>();
        Map<String, String> delegate = new HashMap<>();
        for (int i = 0; i < vals.length; ++i) {
            String first = eqs[i][0];
            String second = eqs[i][1];
            if (!delegate.containsKey(first) && !delegate.containsKey(second)) {
                Map<String, Double> map = new HashMap<>();
                map.put(second, vals[i]);
                map.put(first, 1.0);
                graphMap.put(first, map);
                delegate.put(first, first);
                delegate.put(second, first);
            } else {
                String firstDelegate = delegate.get(first);
                String secondDelegate = delegate.get(second);
                if (firstDelegate != null && secondDelegate != null) {
                    Map<String, Double> tmpMap = graphMap.get(secondDelegate);
                    Map<String, Double> map = graphMap.get(firstDelegate);
                    Double firstValue = map.get(first);
                    Double secondValue = tmpMap.get(second);
                    for (Map.Entry<String, Double> entry : tmpMap.entrySet()) {
                        String key = entry.getKey();
                        Double value = entry.getValue();
                        delegate.put(key, firstDelegate);
                        map.put(key, (value / secondValue) * vals[i] * firstValue);
                    }
                    graphMap.remove(secondDelegate);
                } else if (firstDelegate != null) {
                    Map<String, Double> map = graphMap.get(firstDelegate);
                    delegate.put(second, firstDelegate);
                    map.put(second, vals[i] * map.get(first));
                } else {
                    Map<String, Double> map = graphMap.get(secondDelegate);
                    delegate.put(first, secondDelegate);
                    map.put(first, map.get(second) / vals[i]);
                }
            }
        }

        double[] rs = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String firstDelegate = delegate.get(queries[i][0]);
            String secondDelegate = delegate.get(queries[i][1]);
            if (firstDelegate == null || secondDelegate == null || !firstDelegate.equals(secondDelegate)) {
                rs[i] = -1;
                continue;
            }
            Map<String, Double> map = graphMap.get(firstDelegate);
            double val1 = map.get(queries[i][0]);
            double val2 = map.get(queries[i][1]);
            rs[i] = val2 / val1;
        }

        return rs;
    }

    public static void main(String[] args) {
        String[][] eqs = {{"a", "b"}, {"c", "d"}, {"c", "b"}};
        double[] vals = {0.5, 2.5, 4};
        String[][] queries = {{"a", "c"}, {"a", "d"}, {"d", "b"}};
        double[] rs = calcEq(eqs, vals, queries);
        for (double val : rs) {
            System.out.println(val);
        }
    }
}
