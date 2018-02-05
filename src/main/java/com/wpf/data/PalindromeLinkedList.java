package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/5.
 */
public class PalindromeLinkedList {

    private static class Node {
        private Integer val;
        private Node next;
    }

    public static boolean palindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node mid = head, two = head;
        boolean odd = true;
        while (mid != null && two != null && two.next != null) {
            mid = mid.next;
            two = two.next.next;
            if (two == null) {
                odd = false;
            }
        }

        Node p = head, pre = null;
        while (p != mid) {
            Node next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        Node newHead = pre;
        if (odd) {
            mid = mid.next;
        }
        while (mid != null && newHead != null) {
            if (!mid.val.equals(newHead.val)) {
                return false;
            }
            mid = mid.next;
            newHead = newHead.next;
        }

        return mid == newHead;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        Node node = new Node();
        node.val = 2;
        head.next = node;
        Node node2 = new Node();
        node2.val = 1;
        node.next = node2;

        System.out.println(palindrome(head));
    }

}
