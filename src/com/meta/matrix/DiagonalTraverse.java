package com.meta.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int row = mat.length;
        int col = mat[0].length;

        int[] ret = new int[row * col];

        int x = 0, y = 0;

        int k = 0;
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < row + col - 1; ++i ) {

            tmp.clear();

            int r = i < col ? 0 : i - col + 1;
            int c = i < col ? i : col - 1;

            while ( r < row && c > -1 ) {
                tmp.add(mat[r][c]);
                ++r;
                --c;
            }

            if ( i % 2 == 0 ) {
                Collections.reverse(tmp);
            }

            for (int j = 0; j < tmp.size(); j++) {
                ret[k++] = tmp.get(j);
            }


        }

        return ret;

    }
}
