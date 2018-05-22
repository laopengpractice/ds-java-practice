package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/21.
 */
public class SurRegions_130 {

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, '1');
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1, '1');
            }
        }

        for (int i = 0; i < board[0].length; ++i) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, '1');
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i, '1');
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '1') {
                    board[i][j] ='O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j, char target) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != 'O') {
            return;
        }

        board[i][j] = target;
        dfs(board, i - 1, j, target);
        dfs(board, i + 1, j, target);
        dfs(board, i, j - 1, target);
        dfs(board, i, j + 1, target);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};

        solve(board);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
