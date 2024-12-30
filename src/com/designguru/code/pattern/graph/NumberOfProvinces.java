package com.designguru.code.pattern.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * There are n cities. Some of them are connected in a network.
 * If City A is directly connected to City B, and City B is directly connected to City C, city A is directly connected to City C.
 *
 * If a group of cities are connected directly or indirectly, they form a province.
 *
 * Given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise, determine the total number of provinces.
 *
 */
public class NumberOfProvinces {

    private int[] parent; // Array to store the root of each node.

    // Function to find the province count.
    public int findProvinces(int[][] isConnected) {

        List<Integer> provinces = new ArrayList<>();

        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {

            Stack<Integer> stack = new Stack<>();

            if (visited[i]) {
                continue;
            } else {
                provinces.add(i);
            }

            stack.push(i);

            while (!stack.isEmpty()) {

                int current = stack.pop();

                if (visited[current]) {
                    continue;
                }

                int[] array = isConnected[current];

                for (int a  = 0; a < array.length; a++ ) {
                    if (isConnected[current][a] == 1 && a != current && !visited[a]) {
                        stack.push(a);
                    }
                }

                visited[current] = true;
            }
        }

        return provinces.size();
    }

}
