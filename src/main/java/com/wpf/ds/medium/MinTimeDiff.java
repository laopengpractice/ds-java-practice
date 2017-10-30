package com.wpf.ds.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/30.
 */
public class MinTimeDiff {

    public static int minTimeDiff(String[] times) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : times) {
            int minute = timeToMinutes(time);
            minutes.add(minute);
        }

        Collections.sort(minutes);
        int diff = minutes.get(0) + 24 * 60 - minutes.get(times.length - 1);
        for (int i = 1; i < times.length; ++i) {
            int curDiff = minutes.get(i) - minutes.get(i - 1);
            if (curDiff < diff) {
                diff = curDiff;
            }
        }

        return diff;
    }

    private static int timeToMinutes(String time) {
        int hour = (time.charAt(0) - '0') * 10 + time.charAt(1);
        int minute = (time.charAt(3) - '0') * 10 + time.charAt(4);

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        String[] times = new String[]{"06:00", "00:00", "12:10", "23:01", "15:30"};
        System.out.println(minTimeDiff(times));
    }
}
