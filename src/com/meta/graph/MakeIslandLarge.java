package com.meta.graph;

import kotlin.Pair;

import java.util.*;

public class MakeIslandLarge {

    final static int[][] directions = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};

    public int largestIsland(int[][] grid) {

        Map<Integer, Integer> sizeMap = new HashMap<>();

        int id = 2;

        for ( int i = 0; i < grid.length; ++i ) {
            for ( int j = 0; j < grid[i].length; ++j ) {
                if ( grid[i][j] == 1 ) {
                    int size = dfs(grid, i, j, new Stack<>(), id);
                    sizeMap.put(id, size);
                    id++;
                }
            }
        }

        int maxSize = Integer.MIN_VALUE;

        for ( int i = 0; i < grid.length; ++i ) {
            for ( int j = 0; j < grid[i].length; ++j ) {
                if ( grid[i][j] == 0 ) {
                    int totalSize = 0;
                    Set<Integer> ids = new HashSet<>();

                    for ( int[] d : directions ) {

                        int x = d[0] + i;
                        int y = d[1] + j;

                        if ( x < 0 || y < 0 || x >= grid.length || y >= grid[i].length ) {
                            continue;
                        }

                        int adjId = grid[x][y];

                        if ( adjId != 0 && !ids.contains(adjId) ) {
                            ids.add(adjId);
                            totalSize += sizeMap.get(adjId);
                        }
                    }

                    maxSize = Math.max(maxSize, totalSize + 1);
                }
            }
        }

        return maxSize == Integer.MIN_VALUE && sizeMap.size() == 1 ? sizeMap.values().iterator().next() : maxSize;


    }

    int dfs(int[][] grid, int i, int j, Stack<Pair<Integer, Integer>> path, int id) {

        if ( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1 ) {
            return 0;
        }

        int c = grid[i][j];

        if ( path.contains(c) ) {
            return 0;
        }

        path.add(new Pair<>(i, j));

        grid[i][j] = id;

        int size = 1;

        for ( int[] d : directions ) {

            int x = d[0] + i;
            int y = d[1] + j;

            size += dfs(grid, x, y, path, id);

        }

        return size;


    }

    public static void main(String[] args) {
        MakeIslandLarge m = new MakeIslandLarge();

        List<int[][]> p = List.of(
                new int[][] {{ 1,0},{0,1 }},
                new int[][] {{1,1},{1,0}},
                new int[][] {{1,1},{1,1}}
        );


        for ( int[][] pp : p ) {
           System.out.println( m.largestIsland(pp));
        }
    }
}
