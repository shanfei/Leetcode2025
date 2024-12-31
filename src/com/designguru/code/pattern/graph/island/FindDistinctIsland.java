package com.designguru.code.pattern.graph.island;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * You are given a 2D matrix containing only 1s (land) and 0s (water).
 *
 * An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water).
 * Each cell is considered connected to other cells horizontally or vertically (not diagonally).
 *
 * Two islands are considered the same if and only if they can be translated (not rotated or reflected) to equal each other.
 *
 * Write a function to find the number of distinct islands in the given matrix.
 *
 * 所有的 岛屿问题 都是 把岛屿 访问过的 置一个不同的值
 *
 *
 */
public class FindDistinctIsland {

    public int findDistinctIslandsDFS(int[][] matrix) {

        Set<DistinctMatrix> s = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( matrix[i][j] == 1 ) {
                    DistinctMatrix d = new DistinctMatrix();

                    int xOffset = i;
                    int yOffset = j;

                    probe(matrix, i, j, xOffset, yOffset, d);
                    s.add(d);
                }
            }
        }


        return s.size();
    }

    public void probe(int[][] matrix, int i, int j, int offsetX, int offsetY, DistinctMatrix dm) {

        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0 ) {
            return;
        }

        matrix[i][j] = 0;

        dm.add(new Point(i - offsetX, j - offsetY));

        int[][] ds = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] d: ds) {
            probe(matrix, i + d[0], j + d[1], offsetX, offsetY, dm);
        }

    }

}

class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class DistinctMatrix {

    Set<Point> points = new HashSet<>();

    public void add(Point p) {
        points.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistinctMatrix that = (DistinctMatrix) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
