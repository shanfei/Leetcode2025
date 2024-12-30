package com.designguru.code.pattern.graph;

import java.util.*;

/**
 *
 * Given an undirected graph, represented as a list of edges. Each edge is illustrated as a pair of integers [u, v], signifying that there's a mutual connection between node u and node v.
 *
 * You are also given starting node start, and a destination node end, return true if a path exists between the starting node and the destination node. Otherwise, return false.
 *
 */
public class FindIfPathExistsInGraph {

    private boolean[] visited; // To keep track of visited nodes

    public boolean validPath(int n, int[][] edges, int start, int end) {
        visited = new boolean[n];

        // 建立邻接表
        Map<Integer, List<Integer>> adjancetArray = new HashMap<>();

        for (int[] e : edges) {
            List<Integer> ed = adjancetArray.getOrDefault(e[0], new ArrayList<>());
            ed.add(e[1]);
            adjancetArray.put(e[0], ed);

            List<Integer> ed1 = adjancetArray.getOrDefault(e[1], new ArrayList<>());
            ed1.add(e[0]);
            adjancetArray.put(e[1], ed1);
        }

        // 基于栈的深度历遍
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            int curr = stack.pop();

            if (visited[curr]) {
                continue;
            }

            if (curr == end) {
                return true;
            }

            List<Integer> l = adjancetArray.get(curr);

            if (l == null) {
                continue;
            }

            for (int e : l) {
                stack.push(e);

            }

            visited[curr] = true;

        }


        return false;
    }
}
