package com.wpf.ds.medium;

import com.wpf.ds.common.LinkListUtils;
import com.wpf.ds.common.LinkList;
import com.wpf.ds.common.PrintUtils;
import java.util.Stack;

/**
 * Created by wenpengfei on 2017/10/27.
 */
public class AddTwoNumbers {

    public static LinkList addTwoNumbers2(LinkList l1, LinkList l2) {
        Stack<Integer> st1 = toStack(l1);
        Stack<Integer> st2 = toStack(l2);

        LinkList head = new LinkList(0);
        int carry = 0;
        while (!st1.empty() && !st1.empty()) {
            int v = st1.pop() + st2.pop() + carry;
            LinkList node = new LinkList(v % 10);
            node.next = head.next;
            head.next = node;
            carry = v / 10;
        }
        if (carry != 0) {
            head.val = carry;
        }

        return head.val == 0 ? head.next : head;
    }

    private static Stack<Integer> toStack(LinkList l) {
        Stack<Integer> st = new Stack<>();
        if (l == null) {
            return st;
        }
        while (l != null) {
            st.push(l.val);
            l = l.next;
        }

        return st;
    }

    public static LinkList addTwoNumbers(LinkList l1, LinkList l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            return addTwoNumbers(l2, l1);
        }

        LinkList p1 = l1, p2 = l2;
        int diff = len1 - len2;
        while (diff > 0) {
            p1 = p1.next;
            diff--;
        }

        while (p1 != null && p2 != null) {
            p1.val += p2.val;
            p1 = p1.next;
            p2 = p2.next;
        }

        int carry = format(l1);
        if (carry != 0) {
            LinkList newHead = new LinkList(carry);
            newHead.next = l1;
            l1 = newHead;
        }

        return l1;
    }

    private static int format(LinkList node) {
        if (node == null) {
            return 0;
        }
        int carry = format(node.next);
        int val = carry + node.val;
        node.val = val % 10;
        return val / 10;
    }

    private static int length(LinkList l) {
        int rs = 0;
        while (l != null) {
            l = l.next;
            rs++;
        }
        return rs;
    }

    public static void main(String[] args) {
        LinkList l1 = LinkListUtils.create(new int[]{7, 2, 4, 3});
        LinkList l2 = new LinkListUtils().create(new int[]{5, 6, 4});
        LinkList rs = addTwoNumbers(l1, l2);
        PrintUtils.printLinkList(rs);
    }
}
