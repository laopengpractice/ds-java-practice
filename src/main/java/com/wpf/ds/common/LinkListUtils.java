package com.wpf.ds.common;

/**
 * Created by wenpengfei on 2017/10/27.
 */
public class LinkListUtils {

    public static LinkList create(int[] nums) {
        LinkList head = new LinkList(0);
        LinkList p = head;
        for (int n : nums) {
            LinkList item = new LinkList(n);
            p.next = item;
            p = item;
        }

        return head.next;
    }
}
