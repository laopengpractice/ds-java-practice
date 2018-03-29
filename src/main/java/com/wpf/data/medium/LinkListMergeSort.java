package com.wpf.data.medium;

import com.wpf.data.common.LinkList;
import com.wpf.data.common.PrintUtils;

/**
 * Created by wenpengfei on 2018/3/21.
 */
public class LinkListMergeSort {

    public static LinkList linkListMergeSort(LinkList head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkList p1 = head;
        LinkList p2 = head;

        while (p2 != null) {
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p2 == null) {
                break;
            }
            p1 = p1.next;
        }

        LinkList head2 = p1.next;
        p1.next = null;
        LinkList l1 = linkListMergeSort(head);
        LinkList l2 = linkListMergeSort(head2);

        return merge(l1, l2);
    }

    private static LinkList merge(LinkList list1, LinkList list2) {
        LinkList head = new LinkList(0);
        LinkList p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        LinkList input = new LinkList(5);
        input.next = new LinkList(3);
        input.next.next = new LinkList(6);
        input.next.next.next = new LinkList(11);
        input.next.next.next.next = new LinkList(1);
        input.next.next.next.next.next = new LinkList(2);
        LinkList rs = linkListMergeSort(input);
        PrintUtils.printLinkList(rs);
    }
}
