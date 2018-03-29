package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/3/22.
 */
public class MyCalendar {

    private List<List<Integer>> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int b = 0, e = events.size() - 1;
        int idx = -1;
        while (b <= e) {
            int m = (b + e) / 2;
            if (events.get(m).get(0) == start) {
                idx = m;
                break;
            } else if (events.get(m).get(0) < start) {
                b = m + 1;
            } else {
                e = m - 1;
            }
        }

        if (idx != -1) {
            //overlap
            return false;
        }

        if ((b - 1 >= 0 && start < events.get(b - 1).get(1)) || (b < events.size() && end > events.get(b).get(0)) ) {
            return false;
        }

        List<Integer> range = new ArrayList<>();
        range.add(start);
        range.add(end);
        events.add(b, range);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(1, 10));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(15, 20));
        System.out.println(myCalendar.book(10, 15));
        System.out.println(myCalendar.book(15, 15));
        System.out.println(myCalendar.book(25, 30));
        System.out.println(myCalendar.book(20, 30));
    }
}
