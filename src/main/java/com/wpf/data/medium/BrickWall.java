package com.wpf.data.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/10/30.
 */
public class BrickWall {

    public static int brickWall(int[][] walls) {
        int h = walls.length;
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 0; i < h; ++i) {
            int offset = 0;
            for (int j = 0; j < walls[i].length - 1; ++j) {
                int x = offset + walls[i][j];
                Integer c = count.get(x);
                if (c == null) {
                    c = 0;
                }
                c++;
                count.put(x, c);
                if (max < c) {
                    max = c;
                }
                offset = x;
            }
        }

        return h - max;
    }

    public static void main(String[] args) {
        int[][] wall = new int[6][];
        wall[0] = new int[]{1, 2, 2, 1};
        wall[1] = new int[]{3, 1, 2};
        wall[2] = new int[]{1, 3, 2};
        wall[3] = new int[]{2, 4};
        wall[4] = new int[]{3, 1, 2};
        wall[5] = new int[]{1, 3, 1, 1};
        System.out.println(brickWall(wall));
    }
}
