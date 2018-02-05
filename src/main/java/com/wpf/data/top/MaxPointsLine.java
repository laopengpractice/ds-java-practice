package com.wpf.data.top;

import com.wpf.data.common.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/11/27.
 */
public class MaxPointsLine {

    public static int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; ++j) {
                Double ratio = Double.NaN;
                if (points[j].x - points[i].x != 0) {
                    ratio = (points[j].y - points[i].y) / (1.0 * (points[j].x - points[i].x));
                }
                Integer num = map.get(ratio);
                if (num == null) {
                    num = 0;
                }
                num++;
                if (num > max) {
                    max = num;
                }
                map.put(ratio, num);
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(2, 3);
        points[4] = new Point(3, 3);
        System.out.println(maxPoints(points));
    }
}
