package com.wpf.ds.medium;

import com.wpf.ds.common.LinkListUtils;
import com.wpf.ds.common.LinkNode;
import com.wpf.ds.common.PrintUtils;

/**
 * Created by wenpengfei on 2017/10/27.
 */
public class AddTwoNumbers {

    public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            return addTwoNumbers(l2, l1);
        }

        LinkNode p1 = l1, p2 = l2;
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
            LinkNode newHead = new LinkNode(carry);
            newHead.next = l1;
            l1 = newHead;
        }

        return l1;
    }

    private static int format(LinkNode node) {
        if (node == null) {
            return 0;
        }
        int carry = format(node.next);
        int val = carry + node.val;
        node.val = val % 10;
        return val / 10;
    }

    private static int length(LinkNode l) {
        int rs = 0;
        while (l != null) {
            l = l.next;
            rs++;
        }
        return rs;
    }

    public static void main(String[] args) {
        LinkNode l1 = LinkListUtils.create(new int[]{7, 2, 4, 3});
        LinkNode l2 = new LinkListUtils().create(new int[]{5, 6, 4});
        LinkNode rs = addTwoNumbers(l1, l2);
        PrintUtils.printLinkList(rs);
    }
}
