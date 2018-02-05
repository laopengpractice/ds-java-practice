package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/6.
 */
public class DistinctMostK {

    static class Node {
        private int key;
        private int val;
        private Node next;
    }

    private static boolean mostK(int[] nums, int k) {
        if (nums.length < 2 || k < 1) {
            return false;
        }

        int bucketCnt = 11111;
        Node[] nodes = new Node[bucketCnt];
        for (int i = 0; i < nums.length; ++i) {
            int bucketIdx = nums[i] % bucketCnt;
            if (nodes[bucketIdx] == null) {
                Node node = new Node();
                node.key = nums[i];
                node.val = i;
                nodes[bucketIdx] = node;
            } else {
                Node p = nodes[bucketIdx];
                while (p != null) {
                    if (p.key == nums[i]) {
                        if (i - p.val <= k) {
                            return true;
                        }
                        p.val = i;
                        break;
                    }
                    p = p.next;
                }
                if (p == null) {
                    Node node = new Node();
                    node.key = nums[i];
                    node.val = i;
                    node.next = nodes[bucketIdx].next;
                    nodes[bucketIdx].next = node;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 10, 20, 1, 5, 6, 7, 9, 8};
        System.out.println(mostK(nums, 3));
    }
}
