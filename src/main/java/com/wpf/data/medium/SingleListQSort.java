package com.wpf.data.medium;

import com.wpf.data.common.LinkList;
import com.wpf.data.common.PrintUtils;

/**
 * Created by wenpengfei on 2018/3/16.
 */
public class SingleListQSort {

    public static LinkList qSortSingleList(LinkList head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkList first = head;
        LinkList p = head.next;
        LinkList ltHead = null, lt = null;
        LinkList eqHead = null, eq = null;
        LinkList gtHead = null, gt = null;

        while (p != null) {
            if (p.val < first.val) {
                if (ltHead == null) {
                    ltHead = lt = p;
                } else {
                    lt.next = p;
                    lt = p;
                }
            } else if (p.val > first.val) {
                if (gtHead == null) {
                    gtHead = gt = p;
                } else {
                    gt.next = p;
                    gt = p;
                }
            } else {
                if (eqHead == null) {
                    eqHead = eq = p;
                } else {
                    eq.next = p;
                    eq = p;
                }
            }

            p = p.next;
        }

        first.next = eqHead;
        eqHead = first;
        if (eq != null) {
            eq.next = null;
        }

        if (lt != null) {
            lt.next = null;
        }
        ltHead = qSortSingleList(ltHead);
        if (gt != null) {
            gt.next = null;
        }
        gtHead = qSortSingleList(gtHead);
        LinkList newHead;

        if (eq == null) {
            eqHead.next = gtHead;
        } else {
            eq.next = gtHead;
        }

        if (ltHead == null) {
            newHead = eqHead;
        } else {
            newHead = ltHead;
            while (ltHead.next != null) {
                ltHead = ltHead.next;
            }
            ltHead.next = eqHead;
        }

        return newHead;
    }


    public static void main(String[] args) {
        int[] tests = {3, 1, 2, 6, 4, 11, 9, 10, 8};
        LinkList head = new LinkList(3);
        LinkList p = head;
        for (int i = 1; i < tests.length; ++i) {
            LinkList node = new LinkList(tests[i]);
            p.next = node;
            p = p.next;
        }

        LinkList newHead = qSortSingleList(head);

        PrintUtils.printLinkList(newHead);
    }
}
