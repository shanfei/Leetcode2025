package com.leetcode.amazon.graph;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * You are given an m x n matrix in which each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * At each minute, any fresh orange becomes rotten if it is 4-directionally adjacent to a rotten orange.
 *
 * Return the minimum number of minutes that should be passed until all the orange gets rotten. If it is impossible, return -1.
 *
 * Examples
 * Input: grid =
 * [[2,1,0,0],
 *  [1,1,1,0],
 *  [0,1,1,1],
 *  [0,0,1,2]]
 * Expected Output: 3
 * Justification: The rotten oranges at (0,0) and (3,3) spread the rot to all adjacent fresh oranges. By day 4, all reachable fresh oranges are spoiled. The progression is as follows:
 * Minute 1: Oranges at positions (0, 1), (1, 0), (2, 3), and (3, 2) gets spoiled.
 * Minute 2: Oranges at positions (1, 1), and (2, 2) gets spoiled.
 * Minute 3: Oranges at positions (2, 1), and (1, 2) gets spoiled.
 * Example 2:
 *
 * Input: grid =
 * [[2,1,1],
 *  [1,1,0],
 *  [0,1,2]]
 * Expected Output: 2
 * Justification: The rotten oranges spread the rot to all fresh oranges in 2 minutes, successfully spoiling all of them.
 * Example 3:
 *
 * Input: grid =
 * [[0,2],
 *  [1,0],
 *  [0,1]]
 * Expected Output: -1
 * Justification: In any case, it is not possible that all oranges gets rotten.
 *
 *
 *
 */
public class RottenOranges {

    public int orangesRotting(int[][] grid) {




        return 0;
    }


}
