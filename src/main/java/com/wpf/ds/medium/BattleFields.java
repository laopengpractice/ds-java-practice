package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/9/19.
 */
public class BattleFields {

    public static int battleFields(char[][] fields) {
        int row = fields.length;
        if (row == 0) {
            return 0;
        }
        int col = fields[0].length;
        int rs = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (fields[i][j] == '.') {
                    continue;
                }
                if ((i > 0 && fields[i - 1][j] == 'X') || (j > 0 && fields[i][j - 1] == 'X')) {
                    continue;
                }
                rs++;
            }
        }

        return rs;
    }
}
