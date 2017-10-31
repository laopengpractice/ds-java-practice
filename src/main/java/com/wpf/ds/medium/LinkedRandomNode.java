package com.wpf.ds.medium;

import com.wpf.ds.common.LinkList;
import java.util.Random;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class LinkedRandomNode {

    private LinkList head;
    private Random random;

    public LinkedRandomNode(LinkList head) {
        this.head = head;
        random = new Random();
    }

    private int random() {
        if (head == null) {
            return 0;
        }

        LinkList cur = head;
        int rs = 0;
        for (int i = 1; cur != null; cur = cur.next, ++i) {
            if (random.nextInt(i) == 0) {
               rs = cur.val;
            }
        }

        return rs;
    }
}
