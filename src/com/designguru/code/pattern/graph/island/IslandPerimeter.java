package com.designguru.code.pattern.graph.island;

/**
 *
 * You are given a 2D matrix containing only 1s (land) and 0s (water).
 *
 * An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water).
 * Each cell is considered connected to other cells horizontally or vertically (not diagonally).
 *
 * There are no lakes on the island, so the water inside the island is not connected to the water around it.
 * A cell is a square with a side length of 1.
 *
 * The given matrix has only one island, write a function to find the perimeter of that island.
 *
 */
public class IslandPerimeter {

    public int findIslandPerimeter(int[][] matrix) {

        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( matrix[i][j] == 1 && visited[i][j] != 1) {
                    return probeB(matrix, i, j, visited);
                }
            }
        }

        return 0;
    }

    /**
     *
     * 计算四周 遇到 0 的加 1 作为 边长的一部分
     *
     * @param matrix
     * @param i
     * @param j
     * @param visited
     * @return
     */
    public int probeB(int[][] matrix, int i, int j, int[][] visited) {

        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0 ) {
            return 1;
        }

        if (visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;

        int[][] ds = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        int c = 0;

        for (int[] d : ds) {

            int a = i + d[0];
            int b = j + d[1];

            c += probeB(matrix, a, b, visited);

        }

        return c;

    }
}
