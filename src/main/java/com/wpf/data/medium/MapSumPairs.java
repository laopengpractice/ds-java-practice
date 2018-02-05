package com.wpf.data.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/22.
 */
public class MapSumPairs {

    static class Node {
        Integer val;
        Map<Character, Node> childMap;

        public Node() {
            childMap = new HashMap<>();
        }
    }

    private Node root = new Node();

    public void insert(String key, int val) {
        Node p = root;
        for (char c : key.toCharArray()) {
            Node child = p.childMap.get(c);
            if (child == null) {
                child = new Node();
                p.childMap.put(c, child);
            }
            p = child;
        }
        p.val = val;
    }

    public int sum(String prefix) {
        Node p = root;
        for (char c : prefix.toCharArray()) {
            if (p == null) {
                return 0;
            }
            p = p.childMap.get(c);
        }

        return sum(p);
    }

    private int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.val != null) {
            val += root.val;
        }
        for (Node child : root.childMap.values()) {
            val += sum(child);
        }
        return val;
    }

    public static void main(String[] args) {
        MapSumPairs pairs = new MapSumPairs();
        pairs.insert("apple", 12);
        pairs.insert("app", 3);
        System.out.println(pairs.sum("ap"));
        pairs.insert("app", 1);
        System.out.println(pairs.sum("app"));
    }
}
