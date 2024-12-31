package com.designguru.code.pattern.graph.island;

import java.util.HashSet;
import java.util.Set;

public class DetectIslandCycle {

    boolean probe(char[][] matrix, int i, int j, char c, Set<Point> visited, int prevX, int prevY) {

        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] != c ) {
            return false;
        }

        Point p = new Point(i, j);

        if (visited.contains(p)) {
            return true;
        }

        visited.add(p);

        int[][] ds = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        boolean hasCycle = false;

        for (int[] d : ds) {
            int nextX = i + d[0];
            int nextY = j + d[1];
            hasCycle = hasCycle || ( ( nextX != prevX ) || ( nextY != prevY ) ) && probe(matrix, nextX, nextY, c, visited, i, j);
        }

        return hasCycle;

    }


    public boolean hasCycle(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char c = matrix[i][j];
                Set<Point> visited = new HashSet<>();
                if (probe(matrix, i, j, c, visited, -1, -1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
