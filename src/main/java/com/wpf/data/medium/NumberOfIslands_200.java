package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/21.
 */
public class NumberOfIslands_200 {

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] v = new boolean[grid.length][grid[0].length];
        int rs = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (v[i][j] || grid[i][j] == '0') {
                    continue;
                }

                visit(grid, v, i, j);
                rs++;
            }
        }

        return rs;
    }

    private static void visit(char[][] grid, boolean[][] v, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0
                || grid[i][j] == '0' || v[i][j]) {
            return;
        }

        v[i][j] = true;
        visit(grid, v, i - 1, j);
        visit(grid, v, i + 1, j);
        visit(grid, v, i, j - 1);
        visit(grid, v, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] intput = new char[][]{{'1', '1', '0', '0'}, {'1', '1', '0', '0'}, {'0', '0', '1', '0'}, {'1', '1', '0', '1'}};

        System.out.println(numIslands(intput));
    }
}
