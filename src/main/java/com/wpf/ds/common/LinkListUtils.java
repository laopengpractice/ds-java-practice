package com.wpf.ds.common;

/**
 * Created by wenpengfei on 2017/10/27.
 */
public class LinkListUtils {

    public static LinkNode create(int[] nums) {
        LinkNode head = new LinkNode(0);
        LinkNode p = head;
        for (int n : nums) {
            LinkNode item = new LinkNode(n);
            p.next = item;
            p = item;
        }

        return head.next;
    }
}
