package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class IntersectionNode {

    static class Node {
        private int val;
        private Node next;
    }

    private static int length(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    public static Node intersectionNode(Node head1, Node head2) {
        int len1 = length(head1);
        int len2 = length(head2);

        Node pLong = head1, pShort = head2;
        int num = len1 - len2;
        if (len2 > len1) {
            pLong = head2;
            pShort = head1;
            num = len2 - len1;
        }
        while (num > 0) {
            pLong = pLong.next;
            num--;
        }

        while (pLong != null && pShort != null) {
            if (pLong == pShort) {
                return pLong;
            }
            pLong = pLong.next;
            pShort = pShort.next;
        }

        return null;
    }

}
