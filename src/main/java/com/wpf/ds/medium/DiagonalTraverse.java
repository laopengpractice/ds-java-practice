package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/27.
 */
public class DiagonalTraverse {

    public static List<Integer> diagonalTraverse(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return rs;
        }
        int col = matrix[0].length;
        int i = 0, j = 0;
        boolean up = true;
        while (i < row && j < col) {
            if (up) {
                while (i >= 0 && j < col) {
                    rs.add(matrix[i][j]);
                    i--;
                    j++;
                }
                i++;
                j--;
                if (j + 1 >= col) {
                    i++;
                } else {
                    j++;
                }
                up = false;
            } else {
                while (i < row && j >= 0) {
                    rs.add(matrix[i][j]);
                    i++;
                    j--;
                }
                i--;
                j++;
                if (i + 1 >= row) {
                    j++;
                } else {
                    i++;
                }
                up = true;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1};
        List<Integer> rs = diagonalTraverse(matrix);
        PrintUtils.printList(rs);
    }
}
