package com.wpf.data.medium;

import com.wpf.data.common.Interval;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wenpengfei on 2017/11/21.
 */
public class NonOverlapIntervals {

    public static int nanOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.start);
                }

                return Integer.compare(o1.end, o2.end);
            }
        });

        int rs = 1;
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (!intersect(pre, intervals[i])) {
                rs++;
                pre = intervals[i];
            }
        }

        return intervals.length - rs;
    }

    private static boolean intersect(Interval v1, Interval v2) {
        if (v2.start < v1.end) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[2];
        intervals[0] = new Interval(1, 2);
        intervals[1] = new Interval(2, 3);
        System.out.println(nanOverlapIntervals(intervals));
    }
}
