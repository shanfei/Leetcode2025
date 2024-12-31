package com.designguru.code.pattern.graph.island;

/**
 *
 * You are given a 2D matrix containing only 1s (land) and 0s (water).
 *
 * An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water).
 * Each cell is considered connected to other cells horizontally or vertically (not diagonally).
 *
 * A closed island is an island that is totally surrounded by 0s (i.e., water).
 * This means all horizontally and vertically connected cells of a closed island are water.
 * This also means that, by definition, a closed island can't touch an edge (as then the edge cells are not connected to any water cell).
 *
 * Write a function to find the number of closed islands in the given matrix.
 *
 */
public class NumberOfClosedIsland {

    public int countClosedIslands(int[][] matrix) {

        int countClosedIslands = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( matrix[i][j] == 1 ) {
                    if (probeA(matrix, i, j)) {
                        countClosedIslands++;
                    }
                }
            }
        }

        return countClosedIslands;
    }

    public boolean probeA(int[][] matrix, int i, int j) {

        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0 ) {
            return true;
        }

        if (i == 0 || j == 0 || j == matrix[i].length - 1 || i == matrix.length - 1) {
            return false;
        }

        matrix[i][j] = 0;

        int[][] ds = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        boolean result = true;

        for (int[] d : ds) {
            result = result & probeA(matrix, i + d[0], j + d[1]);
        }

        return result;

    }

}
