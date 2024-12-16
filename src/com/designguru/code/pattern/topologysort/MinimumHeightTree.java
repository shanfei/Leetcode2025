package com.designguru.code.pattern.topologysort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * We are given an undirected graph that has the characteristics of a k-ary tree.
 *
 * In such a graph, we can choose any node as the root to make a k-ary tree.
 * The root (or the tree) with the minimum height will be called Minimum Height Tree (MHT).
 * There can be multiple MHTs for a graph.
 *
 * In this problem, we need to find all those roots which give us MHTs.
 * Write a method to find all MHTs of the given graph and return a list of their roots.
 *
 * Example 1:
 *
 * Input: vertices: 5, Edges: [[0, 1], [1, 2], [1, 3], [2, 4]]
 * Output:[1, 2]
 * Explanation: Choosing '1' or '2' as roots give us MHTs. In the below diagram,
 * we can see that the height of the trees with roots '1' or '2' is three which is the minimum.
 *
 */
public class MinimumHeightTree {

    public List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();



        return minHeightTrees;
    }
}
