package com.wpf.ds.medium;

import com.wpf.ds.common.LinkNode;
import java.util.Random;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class LinkedRandomNode {

    private LinkNode head;
    private Random random;

    public LinkedRandomNode(LinkNode head) {
        this.head = head;
        random = new Random();
    }

    private int random() {
        if (head == null) {
            return 0;
        }

        LinkNode cur = head;
        int rs = 0;
        for (int i = 1; cur != null; cur = cur.next, ++i) {
            if (random.nextInt(i) == 0) {
               rs = cur.val;
            }
        }

        return rs;
    }
}
