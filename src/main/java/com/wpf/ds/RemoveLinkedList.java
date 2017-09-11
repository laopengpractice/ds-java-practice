package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/5.
 */
public class RemoveLinkedList {

    private static class Node {
        private Integer val;
        private Node next;
    }

    public static Node removeDuplicate(Node head, Integer val) {
        Node newHead = new Node();
        newHead.next = head;
        Node pre = newHead, p = head;
        while (p != null) {
            if (p.val.equals(val)) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }

        return newHead.next;
    }
}
