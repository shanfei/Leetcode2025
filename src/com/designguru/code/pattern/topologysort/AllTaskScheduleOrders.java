package com.designguru.code.pattern.topologysort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Problem Statement
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 *
 * Given the number of tasks and a list of prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites.
 *
 * Examples
 * Example 1:
 *
 * Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output:
 * 1) [3, 2, 0, 1]
 * 2) [3, 2, 1, 0]
 * Explanation: There are two possible orderings of the tasks meeting all prerequisites.
 * Example 2:
 *
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: [0, 1, 2]
 * Explanation: There is only possible ordering of the tasks.
 * Example 3:
 *
 * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
 * Output:
 * 1) [0, 1, 4, 3, 2, 5]
 * 2) [0, 1, 3, 4, 2, 5]
 * 3) [0, 1, 3, 2, 4, 5]
 * 4) [0, 1, 3, 2, 5, 4]
 * 5) [1, 0, 3, 4, 2, 5]
 * 6) [1, 0, 3, 2, 4, 5]
 * 7) [1, 0, 3, 2, 5, 4]
 * 8) [1, 0, 4, 3, 2, 5]
 * 9) [1, 3, 0, 2, 4, 5]
 * 10) [1, 3, 0, 2, 5, 4]
 * 11) [1, 3, 0, 4, 2, 5]
 * 12) [1, 3, 2, 0, 5, 4]
 * 13) [1, 3, 2, 0, 4, 5]
 *
 * toplogic sort with backtrack
 *
 * dfs
 *
 */
// TODO:
public class AllTaskScheduleOrders {

    List<List<Integer>> orders = new ArrayList<>();

    public List<List<Integer>> printOrders(int tasks, int[][] prerequisites) {


        int[] inorders = new int[tasks];

        for ( int[] e : prerequisites ) {
            inorders[e[1]]++;
        }

        for ( int i = 0; i < inorders.length; ++i ) {
            if ( inorders[i] == 0 ) {
                orders.add(toplogicSort(i, prerequisites, inorders));
            }
        }


        return orders;
    }

    public List<Integer> toplogicSort(int v, int[][] edges, int[] inordersI) {

        int[] inorders = new int[inordersI.length];

        for (int i = 0 ; i < inordersI.length; ++i) {
            inorders[i] = inordersI[i];
        }

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);

        while ( !queue.isEmpty() ) {

            int t = queue.poll();

            for ( int[] e : edges ) {
                if ( e[0] == t ) {
                    if ( --inorders[e[1]] == 0 ) {
                        queue.add(e[1]);
                    }
                }
            }

            result.add(t);
        }

        return result;

    }
}
