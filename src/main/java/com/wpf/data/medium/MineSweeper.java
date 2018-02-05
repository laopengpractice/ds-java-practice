package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

/**
 * Created by wenpengfei on 2017/9/29.
 */
public class MineSweeper {

    public static void mineSweeper(Character[][] mines, int x, int y) {
        if (x < 0 || y < 0 || x > mines.length - 1 || y > mines[0].length - 1) {
            return;
        }

        if (mines[x][y] == 'M') {
            mines[x][y] = 'X';
            return;
        } else if (mines[x][y] == 'E') {
            int mineNum = mineNum(mines, x, y);
            if (mineNum == 0) {
                mines[x][y] = 'B';
                mineSweeper(mines, x - 1, y);
                mineSweeper(mines, x - 1, y - 1);
                mineSweeper(mines, x - 1, y + 1);
                mineSweeper(mines, x, y - 1);
                mineSweeper(mines, x, y + 1);
                mineSweeper(mines, x + 1, y);
                mineSweeper(mines, x + 1, y - 1);
                mineSweeper(mines, x + 1, y + 1);
            } else {
                mines[x][y] = (char)('0' + mineNum);
            }
        }

        return;
    }

    private static int mineNum(Character[][] mines, int x, int y) {
        int num = 0;
        for (int i = - 1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && y == 0) {
                    continue;
                }
                if (isMine(mines, x + i, y + j)) {
                    num++;
                }
            }
        }

        return num;
    }

    private static boolean isMine(Character[][] mines, int x, int y) {
        if (x < 0 || y < 0 || x > mines.length - 1 || y > mines[0].length - 1) {
            return false;
        }
        return mines[x][y] == 'M' || mines[x][y] == 'X';
    }

    public static void main(String[] args) {
        Character[][] mines = new Character[4][];
        for (int i = 0; i < 4; ++i) {
            mines[i] = new Character[4];
            for (int j = 0; j < 4; ++j) {
                mines[i][j] = 'E';
            }
        }
        mines[3][2] = 'M';
        mines[0][1] = 'M';
        mineSweeper(mines, 1, 3);
        PrintUtils.print2D(mines);
    }
}
